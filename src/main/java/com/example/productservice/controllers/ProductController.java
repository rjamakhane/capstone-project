package com.example.productservice.controllers;

import com.example.productservice.modals.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping('/{id}')
    public Product getProducts(@PathVariable("id") Long id) {
        return new Product(1L, "Product 1", "Description 1", 100.0, 10, "https://via.placeholder.com/150", 1L, 1L);
    }
}
