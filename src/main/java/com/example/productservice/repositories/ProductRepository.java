package com.example.productservice.repositories;

import com.example.productservice.modals.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    Optional<Product> findByTitle(String title);
    void  deleteById(Long id);
    void deleteByTitle(String title);
    Product save(Product product);
}
