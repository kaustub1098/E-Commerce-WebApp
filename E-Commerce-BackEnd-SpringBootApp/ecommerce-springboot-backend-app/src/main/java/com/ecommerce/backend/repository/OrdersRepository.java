package com.ecommerce.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.backend.entities.OrdersEntity;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {

	@Query("SELECT e from ProductEntity e where e.product_name=?1")
	public List<OrdersEntity> showOrdersByProductName(String name);
	
	
	
}
