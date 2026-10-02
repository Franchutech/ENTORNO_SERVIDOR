package es.decroly.tienda_decroly.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HolaMundoRestController {

        @GetMapping("/saludo")
        public String saludo() {

            return "Hola Mundo";

        }//CIERRE PUBLIC SALUDO

        @GetMapping("/saludo/{nombre}")
    public String saludo(@PathVariable String nombre) {
            return "Hola " + nombre;
        }

        @GetMapping("/buscar")
        //Parametro de consulta: hhtps://localhost:8080/buscar?texto=raton ;
        public String buscar(@RequestParam (defaultValue = "todo") String texto) {
            return "Buscando productos que contentan: " + texto;
        }



}//CIERRE CLASE PRINCIPAL
