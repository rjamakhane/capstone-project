package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDTO;
import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.modals.Category;
import com.example.productservice.modals.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
        if (fakeStoreProductDTO == null) {
            throw new InvalidProductIdException("Invalid Product Id");
        }
        return convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO);
    }

    public Product convertFakeStoreProductDTOtoProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());

        Category category = new Category();
        category.setTitle(fakeStoreProductDTO.getCategory());

//        product.setCategory(category);
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
        if (fakeStoreProductDTO != null) {
            List<Product> products = new ArrayList<>();
            for (FakeStoreProductDTO productDTO : fakeStoreProductDTO) {
                products.add(convertFakeStoreProductDTOtoProduct(productDTO));

            }
            return products;
        }
        return new ArrayList<Product>();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor<>(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO);
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
