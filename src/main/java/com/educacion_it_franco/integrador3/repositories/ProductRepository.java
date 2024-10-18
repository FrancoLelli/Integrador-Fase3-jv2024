package com.educacion_it_franco.integrador3.repositories;

import com.educacion_it_franco.integrador3.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
