package es.decroly.tienda_decroly.controllers;

import es.decroly.tienda_decroly.domain.Producto;
import org.springframework.web.bind.annotation.*;

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
    public List<Producto> getProductos() {
        return productos;
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
    public Producto crear(@RequestBody Producto producto) {
        producto.setId(this.secuencia.incrementAndGet());
        productos.add(producto);
        return producto;
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable long id, @RequestBody Producto producto) {
        for (Producto p : productos) {
            if (p.getId() != null && p.getId().equals(id)) {
                p.setNombre(producto.getNombre());
                p.setPrecio(producto.getPrecio());
                p.setStock(producto.getStock());
                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable long id) {
        return productos.removeIf(p -> p.getId() != null && p.getId().equals(id));
    }
}