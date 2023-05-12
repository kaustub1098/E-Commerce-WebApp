package com.ecommerce.backend.jpa.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.backend.dto.OrdersDTO;
import com.ecommerce.backend.dto.ProductCategoryDTO;
import com.ecommerce.backend.dto.ProductDTO;
import com.ecommerce.backend.dto.ShippingAddressDTO;
import com.ecommerce.backend.dto.UsersDTO;
import com.ecommerce.backend.entities.OrdersEntity;
import com.ecommerce.backend.entities.ProductCategoryEntity;
import com.ecommerce.backend.entities.ProductEntity;
import com.ecommerce.backend.entities.ShippingAddressEntity;
import com.ecommerce.backend.entities.UsersEntity;
import com.ecommerce.backend.repository.OrdersRepository;
import com.ecommerce.backend.services.OrdersService;


@ExtendWith(MockitoExtension.class)
public class OrderServiceUnitTests {
	
	@Mock
	private OrdersRepository ordersRepository;
	
	
	@InjectMocks
	private OrdersService ordersService;
	
	@DisplayName("Junit test for get all orders")
	@Test
	public void givenOrderList_whenGetAllOrders_thenGetOrdersList() {
		
		//given- precondition or setup
		
		//order1
        ProductCategoryEntity category = new ProductCategoryEntity("Electronics");
		ProductEntity product = new ProductEntity("Apple Iphone 14", "A16 Bionic", 70000, 10, "http://assets/apple",category);
		UsersEntity user = new UsersEntity("Rohan","Kulkarni", "Kalyan Maharashtra", "rohanK@gmail.com", "rohan123", "298131");
		ShippingAddressEntity address = new ShippingAddressEntity("Tom" , "Cruise", 2139121, 843920, 3728,"Long Beach", "California", "LA", "USA");
	    OrdersEntity orders1 = new OrdersEntity(LocalDate.of(2023,10,06),LocalTime.of(12, 30, 10),5000L, "CreditCard", product, address);
		
		//order2
	    ProductCategoryEntity category1 = new ProductCategoryEntity("Electronics");
	    ProductEntity product1 = new ProductEntity("Apple Iphone 14", "A16 Bionic", 70000, 10, "http://assets/apple",category);
	    UsersEntity user1 = new UsersEntity("Rohan","Kulkarni", "Kalyan Maharashtra", "rohanK@gmail.com", "rohan123", "298131");
	    ShippingAddressEntity address1 = new ShippingAddressEntity("Tom" , "Cruise", 2139121, 843920, 3728,"Long Beach", "California", "LA", "USA");
	    OrdersEntity orders2 = new OrdersEntity(LocalDate.of(2023,10,06),LocalTime.of(12, 30, 10),5000L, "CreditCard", product, address);
			
		//given
		BDDMockito.given(ordersRepository.findAll()).willReturn(List.of(orders1,orders2));
		
		//when
		List<OrdersDTO>ordersList = ordersService.getOrdersList();
		
		//then
		Assertions.assertThat(ordersList).isNotNull();
		
		Assertions.assertThat(ordersList.size()).isEqualTo(2);
		
	}
	
	/*
	@DisplayName("Junit test for saving orders")
	@Test
	public void giveOrderObject_whenSaved_thenNewSavedOrderObject() {
		
		ProductCategoryDTO category1 =new ProductCategoryDTO("Electronics");
		ProductDTO product = new ProductDTO("Apple iPhone 14", "40 MP camera", 6000, 10, "http://apple", category1);
		
		UsersDTO users = new UsersDTO("Rohan","Kulkarni", "Kalyan Maharashtra", "rohanK@gmail.com", "rohan123", "298131");
		
		ShippingAddressDTO address = new ShippingAddressDTO("Tom" , "Cruise", 2139121, 843920, 3728,"Long Beach", "California", "LA", "USA");
	
		OrdersDTO orders = new OrdersDTO(LocalDate.of(2023,10,06),LocalTime.of(12, 30, 10),5000L, "CreditCard", product, address);
		BDDMockito.given(ordersRepository.save(orders)).willReturn(orders);
		
		//when
		OrdersDTO saveOrder = ordersService.saveOrders(orders);
		
		//Assertions
		org.assertj.core.api.Assertions.assertThat(saveOrder).isNotNull();
		
		}
		*/
	

}
