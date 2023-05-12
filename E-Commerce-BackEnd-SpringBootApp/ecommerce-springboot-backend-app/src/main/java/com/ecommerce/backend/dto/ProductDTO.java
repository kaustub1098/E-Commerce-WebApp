package com.ecommerce.backend.dto;



public class ProductDTO {

		private Long id;
		
		private String product_name;
		
		private String product_description;
		
		private Integer product_price;
		
		private Integer product_stock_quantity;
		
		private String product_image_url;
		
		private ProductCategoryDTO productCategory;
		
	
		public ProductDTO() {
			// TODO Auto-generated constructor stub
		}


		


		public ProductDTO(String product_name, String product_description, Integer product_price,
				Integer product_stock_quantity, String product_image_url, ProductCategoryDTO productCategory) {
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



		@Override
		public String toString() {
			return "ProductDTO [id=" + id + ", product_name=" + product_name + ", product_description="
					+ product_description + ", product_price=" + product_price + ", product_stock_quantity="
					+ product_stock_quantity + ", product_image_url=" + product_image_url + "]";
		}


		public ProductCategoryDTO getProductCategory() {
			return productCategory;
		}


		public void setProductCategory(ProductCategoryDTO productCategory) {
			this.productCategory = productCategory;
		}
		
	


		
		
	
		
		
}
