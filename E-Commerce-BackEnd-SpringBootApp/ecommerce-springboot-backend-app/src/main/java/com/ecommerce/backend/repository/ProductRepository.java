package com.ecommerce.backend.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.backend.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	


	
	
	@Query("SELECT e  from ProductEntity e where e.product_name=?1" )
	public List<ProductEntity> showByName(String name);
	
	@Transactional
	@Modifying
	@Query("DELETE  from ProductEntity e where e.product_name=?1")
	public int deleteByName(String name);
	
	
	
}
