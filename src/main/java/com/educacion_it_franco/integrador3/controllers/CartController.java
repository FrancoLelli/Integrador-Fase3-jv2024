package com.educacion_it_franco.integrador3.controllers;

import com.educacion_it_franco.integrador3.entities.Cart;
import com.educacion_it_franco.integrador3.entities.Product;
import com.educacion_it_franco.integrador3.repositories.ProductRepository;
import com.educacion_it_franco.integrador3.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductRepository productRepository;

    // Mostrar el carrito
    @GetMapping("/{cartId}")
    public String viewCart(@PathVariable Long cartId, Model model) {
        Cart cart = cartService.getCart(cartId);
        model.addAttribute("cart", cart);
        model.addAttribute("total", cart.getTotal());
        return "cart";
    }

    // Mostrar todos los productos
    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    // Agregar un producto al carrito
    @PostMapping("/{cartId}/add")
    public String addToCart(@PathVariable Long cartId, @RequestParam Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            cartService.addToCart(cartId, product);
        }
        return "redirect:/cart/" + cartId;
    }
}
