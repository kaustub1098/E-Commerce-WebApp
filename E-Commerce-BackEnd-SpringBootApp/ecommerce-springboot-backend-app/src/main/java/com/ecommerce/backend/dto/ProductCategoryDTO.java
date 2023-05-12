package com.ecommerce.backend.dto;

import lombok.Data;

@Data
public class ProductCategoryDTO {
	
	private Long id;
	
	private String category_name;

	public ProductCategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductCategoryDTO(Long id, String category_name) {
		super();
		this.id = id;
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
		return "ProductCategoryDTO [id=" + id + ", category_name=" + category_name + "]";
	}
	
	


}
