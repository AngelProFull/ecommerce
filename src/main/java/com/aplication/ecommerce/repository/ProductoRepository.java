package com.aplication.ecommerce.repository;

import com.aplication.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Para poder inyectarla utilizamos anotación Repository
@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer> {
}
