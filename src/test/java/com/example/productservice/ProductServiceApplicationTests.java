package com.example.productservice;

import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import com.example.productservice.repositories.projections.ProductByIdAndTitle;
import com.example.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testQueries() {
		// Test the queries here
		List<ProductByIdAndTitle> prduct = productRepository.someRandomQuery();
		for (ProductByIdAndTitle productByIdAndTitle : prduct) {
			System.out.println(productByIdAndTitle.getTitle());
			System.out.println(productByIdAndTitle.getId());
		}

		categoryRepository.deleteById(52L);

	}

}
