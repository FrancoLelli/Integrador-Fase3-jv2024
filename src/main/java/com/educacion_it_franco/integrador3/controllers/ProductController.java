package com.educacion_it_franco.integrador3.controllers;

import com.educacion_it_franco.integrador3.entities.Product;
import com.educacion_it_franco.integrador3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductService productoService;

    @GetMapping
    public String listarProductos(Model model) {
        List<Product> productos = productoService.obtenerTodos();
        model.addAttribute("productos", productos);
        return "productos/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("producto", new Product());
        return "productos/formulario";
    }

    @PostMapping
    public String crearProducto(@ModelAttribute Product producto) {
        productoService.crearOActualizar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Product producto = productoService.obtenerPorId(id).orElse(null);
        model.addAttribute("producto", producto);
        return "productos/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute Product producto) {
        producto.setId(id);
        productoService.crearOActualizar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }
}