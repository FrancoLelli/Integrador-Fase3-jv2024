package com.educacion_it_franco.integrador3.controllers;

import com.educacion_it_franco.integrador3.entities.Product;
import com.educacion_it_franco.integrador3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ViewController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showProductCatalog(Model model) {
        List<Product> products = productService.obtenerTodos();
        model.addAttribute("products", products);
        return "index";
    }

}
