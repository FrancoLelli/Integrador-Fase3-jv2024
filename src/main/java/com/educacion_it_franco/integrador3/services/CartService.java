package com.educacion_it_franco.integrador3.services;

import com.educacion_it_franco.integrador3.entities.Cart;
import com.educacion_it_franco.integrador3.entities.Product;
import com.educacion_it_franco.integrador3.repositories.CartRepository;
import com.educacion_it_franco.integrador3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productoRepository;

    public Cart agregarProducto(Long cartId, Long productoId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        Optional<Product> productoOptional = productoRepository.findById(productoId);
        if (cartOptional.isPresent() && productoOptional.isPresent()) {
            Cart cart = cartOptional.get();
            Product producto = productoOptional.get();
            cart.getProductos().add(producto);
            cart.setTotal(cart.getTotal() + producto.getPrecio());
            return cartRepository.save(cart);
        }

        return null;
    }

    public Cart obtenerCart(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public Cart crearCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }
}

