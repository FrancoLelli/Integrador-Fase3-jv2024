package com.educacion_it_franco.integrador3.repositories;

import com.educacion_it_franco.integrador3.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
