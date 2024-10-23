package com.educacion_it_franco.integrador3.services;

import com.educacion_it_franco.integrador3.entities.Cart;
import com.educacion_it_franco.integrador3.entities.Product;
import com.educacion_it_franco.integrador3.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId).orElse(new Cart());
    }

    public void addToCart(Long cartId, Product product) {
        Cart cart = getCart(cartId);
        cart.items.addProduct(product);
        cartRepository.save(cart);
    }

    public double getTotal(Long cartId) {
        Cart cart = getCart(cartId);
        return cart.getTotal();
    }
}

