package com.aplication.ecommerce.service;

import com.aplication.ecommerce.model.Producto;
import com.aplication.ecommerce.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductoServiceImpl implements ProductoService{

    //Declaramos un objeto de tipo Producto Repository para acceder a los métodos crud. Con autowired le decimos que estamos inyectando el objeto.

    @Autowired
    ProductoRepository productoRepository;
    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> get(Integer id) {
        return productoRepository.findById(id);
    }

    //El método save de Jpa si le mandamos un id null al Objeto lo crea, pero si el id lo tiene entonces lo actualiza.
    @Override
    public void update(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }
}
