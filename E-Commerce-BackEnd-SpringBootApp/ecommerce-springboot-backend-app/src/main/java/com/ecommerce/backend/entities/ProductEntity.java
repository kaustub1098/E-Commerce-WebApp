package com.ecommerce.backend.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="product_info")

public class ProductEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable=false)
	private Long id;
	
	@Column(name = "product_name",nullable = false)
	private String product_name;
	
	@Column(name = "product_description",nullable = false)
	private String product_description;
	
	@Column(name="product_price",nullable = false)
	private Integer product_price;
	
	
	@Column(name = "product_stock_quantity",nullable = false)
	private Integer product_stock_quantity;
	
	@Column(name="product_image_url",nullable = false)
	private String product_image_url;
	

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="category_id",referencedColumnName = "id")
	private ProductCategoryEntity productCategory;
	
public ProductEntity() {
	// TODO Auto-generated constructor stub
}

public ProductEntity( String product_name, String product_description, Integer product_price,
		Integer product_stock_quantity, String product_image_url, ProductCategoryEntity productCategory) {
	super();
	
	this.product_name = product_name;
	this.product_description = product_description;
	this.product_price = product_price;
	this.product_stock_quantity = product_stock_quantity;
	this.product_image_url = product_image_url;
	this.productCategory = productCategory;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getProduct_name() {
	return product_name;
}

public void setProduct_name(String product_name) {
	this.product_name = product_name;
}

public String getProduct_description() {
	return product_description;
}

public void setProduct_description(String product_description) {
	this.product_description = product_description;
}

public Integer getProduct_price() {
	return product_price;
}

public void setProduct_price(Integer product_price) {
	this.product_price = product_price;
}

public Integer getProduct_stock_quantity() {
	return product_stock_quantity;
}

public void setProduct_stock_quantity(Integer product_stock_quantity) {
	this.product_stock_quantity = product_stock_quantity;
}

public String getProduct_image_url() {
	return product_image_url;
}

public void setProduct_image_url(String product_image_url) {
	this.product_image_url = product_image_url;
}

public ProductCategoryEntity getProductCategory() {
	return productCategory;
}

public void setProductCategory(ProductCategoryEntity productCategory) {
	this.productCategory = productCategory;
}

@Override
public String toString() {
	return "ProductEntity [id=" + id + ", product_name=" + product_name + ", product_description=" + product_description
			+ ", product_price=" + product_price + ", product_stock_quantity=" + product_stock_quantity
			+ ", product_image_url=" + product_image_url +  "]";
}









}
