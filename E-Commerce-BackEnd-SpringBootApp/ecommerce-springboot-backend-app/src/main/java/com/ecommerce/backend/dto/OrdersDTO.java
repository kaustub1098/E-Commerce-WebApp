package com.ecommerce.backend.dto;

import java.time.LocalDate;
import java.time.LocalTime;



public class OrdersDTO {
	 
	  private Long id;
		
	  private LocalDate order_Date;
		
	  private LocalTime order_Time;
		
      private Long orderTotal;
		
      private String payment_type;
      
      private ProductDTO products ;
	
      private ShippingAddressDTO addressList;

	public OrdersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersDTO(LocalDate order_Date, LocalTime order_Time, Long orderTotal, String payment_type,
			ProductDTO products, ShippingAddressDTO addressList) {
		super();
		this.order_Date = order_Date;
		this.order_Time = order_Time;
		this.orderTotal = orderTotal;
		this.payment_type = payment_type;
		this.products = products;
		this.addressList = addressList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(LocalDate order_Date) {
		this.order_Date = order_Date;
	}

	public LocalTime getOrder_Time() {
		return order_Time;
	}

	public void setOrder_Time(LocalTime order_Time) {
		this.order_Time = order_Time;
	}

	public Long getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Long orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public ProductDTO getProducts() {
		return products;
	}

	public void setProducts(ProductDTO products) {
		this.products = products;
	}

	public ShippingAddressDTO getAddressList() {
		return addressList;
	}

	public void setAddressList(ShippingAddressDTO addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "OrdersDTO [id=" + id + ", order_Date=" + order_Date + ", order_Time=" + order_Time + ", orderTotal="
				+ orderTotal + ", payment_type=" + payment_type + ", products=" + products + ", addressList="
				+ addressList + "]";
	}
}

