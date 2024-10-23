package com.educacion_it_franco.integrador3.controllers;


import com.educacion_it_franco.integrador3.entities.Cart;
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

    @GetMapping("/{id}")
    public String verCart(@PathVariable Long id, Model model) {
        Cart cart = cartService.obtenerCart(id);
        model.addAttribute("cart", cart);
        return "cart/ver";
    }

    @PostMapping("/{cartId}/agregar/{productoId}")
    public String agregarProducto(@PathVariable Long cartId, @PathVariable Long productoId) {
        cartService.agregarProducto(cartId, productoId);
        return "redirect:/cart/" + cartId;
    }

    @PostMapping("/crear")
    public String crearCart() {
        Cart cart = cartService.crearCart();
        return "redirect:/cart/" + cart.getId();
    }
}
