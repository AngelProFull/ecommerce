package com.aplication.ecommerce.service;

import com.aplication.ecommerce.model.Producto;
import com.aplication.ecommerce.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

//Métodos crud, en la interface solo definimos los métodos.
public interface ProductoService {



    public Producto save(Producto producto);
    //Optional nos da la opción si existe o no
    public Optional<Producto> get(Integer id);
    //Método actualizar.

    public void update(Producto producto);
    public void delete(Integer id);

    //Funcionalidad para mostrar todos los productos.

    public List<Producto> findAll();
}
