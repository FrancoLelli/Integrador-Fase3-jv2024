package com.educacion_it_franco.integrador3.services;

import com.educacion_it_franco.integrador3.entities.Product;
import com.educacion_it_franco.integrador3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productoRepository;

    public List<Product> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Product> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Product crearOActualizar(Product producto) {
        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}

