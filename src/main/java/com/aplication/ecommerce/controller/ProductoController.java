package com.aplication.ecommerce.controller;

import com.aplication.ecommerce.model.Producto;
import com.aplication.ecommerce.model.Usuario;
import com.aplication.ecommerce.service.ProductoService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/productos")
public class ProductoController {


    //Variable para realizar test.(Logger)
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    //Autowired para no instanciar nosotros.
    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String mostrar() {
        return "administrador/productos/mostrar";
    }

    @GetMapping("/crear")

    public String crear() {
        return "administrador/productos/crear";
    }

    //Método guardar producto. Recibimos un objeto de tipo Producto. Configuramos el actión del form crear

    @PostMapping("/guardar")
    public String guardar(Producto producto) {
        //Realizamos un test antes de guardar. Con {} le indico que después va a venir una variable o un objeto.
        //LOGGER.info("Objeto producto {}",producto);

        //Creamos un usuario

        Usuario usuario = new Usuario(1,"","","","","","","");
        producto.setUsuario(usuario);
        //Implementamos el método guardar, antes tenemos que crear un Usuario.
        productoService.save(producto);
        return "redirect:/productos";
    }
}
