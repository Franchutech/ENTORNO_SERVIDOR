package es.decroly.tienda_decroly.controllers;

import es.decroly.tienda_decroly.domain.Producto;
import es.decroly.tienda_decroly.exceptions.BadRequestException;
import es.decroly.tienda_decroly.exceptions.NotFoundException;
import org.apache.catalina.webresources.JarResourceRoot;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/productos")
public class ProductosRestController {

    // PROVISIONAL: los datos van a estar temporalmente en memoria
    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong secuencia = new AtomicLong();

    public ProductosRestController() {
        anadir("teclado mecanico", 49.90, 15);
        anadir("ratón inalámbrico", 19.95, 15);
        anadir("monitor ultradelgado", 54.65, 20);
    }

    private void anadir(String nombre, double precio, int stock) {
        Long id = this.secuencia.incrementAndGet();
        productos.add(new Producto(id, nombre, precio, stock));
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getProductos() {
        return ResponseEntity.ok(productos);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Producto buscarPorId(@PathVariable Long id) {
        return findbyid(id);
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        validarProducto(producto);//llamo la funcion de las validaciones que hice abajo
        Long id = secuencia.incrementAndGet();
        Producto nuevoProducto = new Producto(id, producto.getNombre(), producto.getPrecio(), producto.getStock());
        productos.add(producto);
        URI direccion = URI.create("/api/productos/" + id);

        return ResponseEntity.created(direccion).body(nuevoProducto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable long id, @RequestBody Producto producto) {
        validarProducto(producto);
        for (Producto p : productos) {
            if (p.getId() != null && p.getId().equals(id)) {
                p.setNombre(producto.getNombre());
                p.setPrecio(producto.getPrecio());
                p.setStock(producto.getStock());

                return p; //Spring devuelve 200 OK
            }
        }
        throw new NotFoundException("No existe el producto con el id: " + id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        boolean eliminado = productos.removeIf(p ->
                p.getId() != null && p.getId().equals(id));

        if (!eliminado) {
            throw new NotFoundException("No existe un producto con el id: " + id);
        }
    }

    private Producto findbyid(long id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new NotFoundException("No existe el producto con el id: " + id);
    }

    private void validarProducto(Producto producto) {

        if (producto == null || producto.getNombre() == null || producto.getNombre().isBlank()) {
            throw new BadRequestException("El producto o su nombre no pueden estar vacíos");
        }

        if (producto.getPrecio() <= 0) {
            throw new BadRequestException("El precio debe ser mayor que cero");
        }
        if (producto.getStock() <= 0) {
            throw new BadRequestException("El stock debe ser mayor que cero");
        }
    }
}//CIERRE PRODUCTOS REST CONTROLLER