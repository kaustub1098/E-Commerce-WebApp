package com.ecommerce.backend.jpa.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.ecommerce.backend.entities.ProductCategoryEntity;
import com.ecommerce.backend.entities.ProductEntity;
import com.ecommerce.backend.repository.ProductRepository;

@ActiveProfiles("test")
@DataJpaTest
public class ProductRespositoryTest {

	@Autowired
	private ProductRepository productRepository;
	
	//Junit Test Case for save product operation.
	@DisplayName("Junit Test case for saving products to DB")
	@Test
	public void giveProductObject_whenSave_thenReturnSavedProduct() {
		
		//given   
		ProductCategoryEntity category = new ProductCategoryEntity("Electronics");
		ProductEntity product=new ProductEntity("Apple Iphone 14", "A16 Bionic", 70000, 10, "http://assets/apple", category);
		
		//when
		ProductEntity newProduct = productRepository.save(product);
		System.out.println("product saved - "+newProduct);
		
		//then
		assertThat(newProduct).isNotNull();
		assertThat(newProduct.getId()).isGreaterThan(0); 
	}
	
	//Junit Test Case for save product operation.
	@DisplayName("Junit Test case for getting products from DB")
	@Test
	public void givenProductList_whenFindAll_thenProductList() {
		
		//given 
		ProductCategoryEntity category = new ProductCategoryEntity("Electronics");
		ProductEntity product=new ProductEntity("Apple Iphone 14", "A16 Bionic", 70000, 10, "http://assets/apple", category);
		productRepository.save(product);

		// when
		List<ProductEntity> productList = productRepository.findAll();
		
		System.out.println("Product List - " + productList);

		// then - Verify the output
		assertThat(productList).isNotNull();
		assertThat(productList.size()).isEqualTo(1);
		
		
		
	}
	
	
	//Junit Test Case for save product operation.
	@DisplayName("Junit Test case for getting product by name from DB")
	@Test
	public void givenFindProductByName_whenFindAll_thenProductList() {
		
		//given 
		ProductCategoryEntity category = new ProductCategoryEntity("Electronics");
		ProductEntity product=new ProductEntity("Apple Iphone 14", "A16 Bionic", 70000, 10, "http://assets/apple", category);
		productRepository.save(product);	
		
		// when
	    List<ProductEntity> productList = productRepository.showByName("Apple Iphone 14");

	 // then - Verify the output
	    assertThat(productList).isNotNull();
	 	assertThat(productList.size()).isEqualTo(1);
		
		
	}
	

	//Junit Test Case for save product operation.
	@DisplayName("Junit Test case for deleting product by name from DB")
	@Test
	public void givenDeleteProductByName_whenDelete_thenReturnStatus() {
		//given 
		ProductCategoryEntity category = new ProductCategoryEntity("Electronics");
		ProductEntity product=new ProductEntity("Apple Iphone 14", "A16 Bionic", 70000, 10, "http://assets/apple", category);
		productRepository.save(product);	
		
		// when
	    int productList  = productRepository.deleteByName("Apple Iphone 14");

	 // then - Verify the output
	    assertThat(productList).isNotNull();
	 	
	    
		
	}
	
	
}