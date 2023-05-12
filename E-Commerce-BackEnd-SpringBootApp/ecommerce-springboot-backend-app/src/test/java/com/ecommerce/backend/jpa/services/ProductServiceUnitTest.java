package com.ecommerce.backend.jpa.services;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.backend.dto.ProductCategoryDTO;
import com.ecommerce.backend.dto.ProductDTO;
import com.ecommerce.backend.entities.ProductCategoryEntity;
import com.ecommerce.backend.entities.ProductEntity;
import com.ecommerce.backend.repository.ProductRepository;
import com.ecommerce.backend.services.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceUnitTest {

	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private ProductService productService;
	
	
	@DisplayName("Junit test for getting all products")
	@Test
	public void givenProductList_whenGetAllProducts_thenGetProductsList() {
		
		//given-precondition or setup
		ProductCategoryEntity category = new ProductCategoryEntity("Electronics");
		ProductEntity product1 = new ProductEntity("Apple Iphone 14", "A16 Bionic", 70000, 10, "http://assets/apple",category);
		
		ProductCategoryEntity category1 = new ProductCategoryEntity("Electronics");
		ProductEntity product2 = new ProductEntity("Apple Iphone 14", "A16 Bionic", 70000, 10, "http://assets/apple",category1);
		
		//given
		BDDMockito.given(productRepository.findAll()).willReturn(List.of(product1,product2));
		
		//when
		List<ProductDTO>productList = productService.getAllProducts();
		
		//then
		Assertions.assertThat(productList).isNotNull();
		Assertions.assertThat(productList.size()).isEqualTo(2);
		
	}
	
	/*
	@DisplayName("Junit test for saving product to DB")
	@Test
	public void giveProductObject_whenSaved_thenNewSavedProductObject() {
		
		//given-precondition or setup
		ProductCategoryDTO category1 =new ProductCategoryDTO("Electronics");
		ProductDTO product = new ProductDTO("Apple iPhone 14", "40 MP camera", 6000, 10, "http://apple",category1);
		
		
		//given
		BDDMockito.given(productRepository.save(product)).willReturn(product);
		
		//when
		ProductDTO saveProduct = productService.saveProduct(product);
		
		//assertions
		Assertions.assertThat(saveProduct).isNotNull();
		
	}*/
	
	
}
