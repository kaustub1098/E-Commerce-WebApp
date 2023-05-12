package com.ecommerce.backend.entities;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name="product_category")
public class ProductCategoryEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	

	@Column(name = "category_name")
	private String category_name;
	

	public ProductCategoryEntity() { 
		//No - Arg Constructor
		}


	public ProductCategoryEntity( String category_name) {
		
		
		this.category_name = category_name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCategory_name() {
		return category_name;
	}


	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


	@Override
	public String toString() {
		return "ProductCategoryEntity [id=" + id + ", category_name=" + category_name + "]";
	}
	


	
}
