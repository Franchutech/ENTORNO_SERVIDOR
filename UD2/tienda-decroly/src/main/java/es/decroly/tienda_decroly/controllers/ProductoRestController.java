package es.decroly.tienda_decroly.controllers;

import es.decroly.tienda_decroly.domain.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class ProductoRestController {

    @RestController
    public static class ProductosRestController {

        //PROVICIONAL : los datos van a estar temporalmente en memoria

        private final List<Producto> productos = new ArrayList<>();
        private final AtomicLong secuencia = new AtomicLong();
        public ProductosRestController() {
            anadir("teclado mecanico", 49.90, 15);
            anadir("ratón inalámbrico", 19.95,15);
            anadir("monitor ultradelgado", 54.65,20);

        }
        private void anadir(String nombre, double precio, int stock) {
            Long id = this.secuencia.incrementAndGet();
            productos.add(new Producto(id, nombre, precio, stock));
        }

        @GetMapping("/api/Productos")
        public List<Producto> getProductos() {
            return productos;
        }

        @GetMapping("api/Productos/{id}")
        public Producto getProductoById(@PathVariable long id) {
           return productos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        }
    }



}//CIERRE REST CONTROLLER
