package es.decroly.tienda_decroly.controllers;

import es.decroly.tienda_decroly.domain.Producto;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.ArrayList;
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
    public Producto getProductoById(@PathVariable long id) {
        for (Producto p : productos) {
            if (p.getId() != null && p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Long id = secuencia.incrementAndGet();
        Producto nuevoProducto = new Producto(id, producto.getNombre(), producto.getPrecio(), producto.getStock());
        productos.add(producto);
        URI direccion = URI.create("/api/productos/" + id);

        return ResponseEntity.created(direccion).body(nuevoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable long id, @RequestBody Producto producto) {
        for (Producto p : productos) {
            if (p.getId() != null && p.getId().equals(id)) {
                p.setNombre(producto.getNombre());
                p.setPrecio(producto.getPrecio());
                p.setStock(producto.getStock());

                // Encontrado y actualizado -> 200 OK con el objeto modificado
                return ResponseEntity.ok(p);
            }
        }

        // Terminó el bucle y no lo encontró -> 404 Not Found
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = productos.removeIf(p -> p.getId() != null && p.getId().equals(id));

        if (eliminado) {
            // Se borró correctamente -> 204 No Content
            return ResponseEntity.noContent().build();
        } else {
            // No se encontró el recurso -> 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
}//CIERRE PRODUCTOS REST CONTROLLER