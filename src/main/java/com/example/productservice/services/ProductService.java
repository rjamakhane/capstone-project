package com.example.productservice.services;

import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.modals.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws InvalidProductIdException;
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product replaceProduct(Long id, Product product);
    void deleteProduct(Long id);

}
