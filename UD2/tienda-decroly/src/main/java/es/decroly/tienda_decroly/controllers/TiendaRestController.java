package es.decroly.tienda_decroly.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TiendaRestController {

    @GetMapping("/info")
    //Parametro de consulta: hhtps://localhost:8080/buscar?texto=raton ;
    public String info() {
        String nombre = "Tienda Decroly <br>";
        String Ciudad = "Santander br>";
        String Horario = "Horario: Lunes a Viernes 24/7 <br>";
        return "La información de la tienda es: " + nombre + Ciudad + Horario;
    }


    @GetMapping("/precio")
    //navegador: http://localhost:8080/precio?precio=100
    public String descuento(@RequestParam(defaultValue = "0") Double precio) {
        // calculo precio
        double precioConDescuento = precio * 0.90;

        return "Precio original: " + precio + "€ | Precio con 10% de descuento: " + precioConDescuento + "€";
    }

    @GetMapping("/descuento/{precio}")
    public String descuento(@PathVariable double precio,
                            @RequestParam(defaultValue = "10") double porcentaje) {

        //calculos
        double precioFinal = precio - (precio * porcentaje / 100);

        return "Precio Original: " + precio + "<br>" +
                "Descuento: " + porcentaje + "%<br>" +
                "Precio Final: " + precioFinal;
    }

}
