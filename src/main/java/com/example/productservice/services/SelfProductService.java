package com.example.productservice.services;

import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.modals.Category;
import com.example.productservice.modals.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        // throw product not found exception
        return optionalProduct.orElse(null);

    }

    @Override

    public List<Product> getAllProducts() {

        //fetch all the products from db

        return null;
    }

    @Override
    public Product createProduct(Product product) {
        /*Category category = product.getCategory();
        if(category.getId() == null){
            category = categoryRepository.save(category);
            product.setCategory(category);
        }*/
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new RuntimeException();
        }
        Product currentProduct = optionalProduct.get();
        if(product == null) throw new RuntimeException("Invalid input");
        if(product.getTitle() != null){
            currentProduct.setTitle(product.getTitle());
        }
        if(product.getDescription() != null){
            currentProduct.setDescription(product.getDescription());
        }
        return productRepository.save(currentProduct);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
