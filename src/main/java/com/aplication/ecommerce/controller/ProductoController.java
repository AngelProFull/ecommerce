package com.aplication.ecommerce.controller;

import com.aplication.ecommerce.model.Producto;
import com.aplication.ecommerce.model.Usuario;
import com.aplication.ecommerce.service.ProductoService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/productos")
public class ProductoController {


    //Variable para realizar test.(Logger)
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    //Autowired para no instanciar nosotros.
    @Autowired
    private ProductoService productoService;

    //Configuramos el método mostrar para que nos muestre una lista de productos.
    //Lo primero le pasamos como parámetro un Objeto de tipo model.
    //Realizamos cambios en mostrar para poder recibir los cambios.
    @GetMapping("")
    public String mostrar(Model model) {
        model.addAttribute("listaproductos",productoService.findAll());
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

    //Obtenemos el id del registro a buscar y pasarlo a la vista para editar.
    //Después de tener el objeto lo pasamos a la vista con Model
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        //Almacenamos el objeto buscado.
        Producto producto = new Producto();
        //Creamos variable de tipo Optional porque es lo que nos devulve al realizar la busqueda del Producto.
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();

        //Utilizamos de LOGGER el método info para saber si lo hemos encontrado.
        LOGGER.info("Producto buscado: {}",producto);
        //Nos envia a la vista el objeto buscado, "producto" es una variable."
        model.addAttribute("producto", producto);
        return "administrador/productos/editar";
    }

    //Actualizar

    @PostMapping("/actualizar")
    public String actualizar(Producto producto) {
        productoService.update(producto);
        return "redirect:/productos";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        productoService.delete(id);
        return "redirect:/productos";
    }



}
