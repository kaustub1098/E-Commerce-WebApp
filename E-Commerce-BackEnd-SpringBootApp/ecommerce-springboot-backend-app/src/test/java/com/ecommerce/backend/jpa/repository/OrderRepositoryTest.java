package com.ecommerce.backend.jpa.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.hibernate.internal.CriteriaImpl.OrderEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.ecommerce.backend.entities.OrdersEntity;
import com.ecommerce.backend.entities.ProductCategoryEntity;
import com.ecommerce.backend.entities.ProductEntity;
import com.ecommerce.backend.entities.ShippingAddressEntity;
import com.ecommerce.backend.entities.UsersEntity;
import com.ecommerce.backend.repository.OrdersRepository;

@ActiveProfiles("test")
@DataJpaTest
public class OrderRepositoryTest {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@DisplayName("Junit Test Case for saving order to DB")
	@Test
	public void giveOrderObject_whenSave_thenReturnSavedOrder() {
		//given 
		
		ProductCategoryEntity category = new ProductCategoryEntity("Electronics");
		
		ProductEntity product = new ProductEntity("Apple Iphone 14", "A16 Bionic", 70000, 10, "http://assets/apple",category);
		
		UsersEntity user = new UsersEntity("Rohan","Kulkarni", "Kalyan Maharashtra", "rohanK@gmail.com", "rohan123", "298131");
		
		ShippingAddressEntity address = new ShippingAddressEntity("Tom" , "Cruise", 2139121, 843920, 3728,"Long Beach", "California", "LA", "USA");
		
		OrdersEntity orders = new OrdersEntity(LocalDate.of(2023,10,06),LocalTime.of(12, 30, 10),5000L, "CreditCard", product, address);
		
		//when
		OrdersEntity newOrder = ordersRepository.save(orders);
		
		
		//then
		assertThat(newOrder).isNotNull();
		assertThat(newOrder.getId()).isGreaterThan(0);
	}
	
	@DisplayName("Junit Test case for getting orders from DB")
	@Test
	public void givenOrderList_whenFindAll_thenOrdersList() {
		

		//given
		ProductCategoryEntity category = new ProductCategoryEntity("Electronics");
		
		ProductEntity product = new ProductEntity("Apple Iphone 14", "A16 Bionic", 70000, 10, "http://assets/apple",category);
		
		UsersEntity user = new UsersEntity("Rohan","Kulkarni", "Kalyan Maharashtra", "rohanK@gmail.com", "rohan123", "298131");
		
		ShippingAddressEntity address = new ShippingAddressEntity("Tom" , "Cruise", 2139121, 843920, 3728,"Long Beach", "California", "LA", "USA");
		
		OrdersEntity orders = new OrdersEntity(LocalDate.of(2023,10,06),LocalTime.of(12, 30, 10),5000L, "CreditCard", product, address);
		
		ordersRepository.save(orders);
		//when
		List<OrdersEntity> orderList = ordersRepository.findAll();
		
		//then
		assertThat(orderList).isNotNull();
		assertThat(orderList.size()).isEqualTo(1);
		
		}
}
