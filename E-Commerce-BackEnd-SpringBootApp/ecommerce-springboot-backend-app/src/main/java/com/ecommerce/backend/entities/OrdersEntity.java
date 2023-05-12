package com.ecommerce.backend.entities;


import java.time.LocalDate;

import java.time.LocalTime;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="orders")
public class OrdersEntity {
		
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="id")
	    private Long id;
		
		@Column(name = "orderDate",nullable =false)
		@CreationTimestamp
	    private LocalDate order_Date;
		
		@Column(name = "orderTime",nullable = false)
	    @CreationTimestamp 
		private LocalTime order_Time;
		
		@Column(name = "orderTotal",nullable = false)
		private Long orderTotal;
		
     @Column(name="payment_type",nullable = false)
	    private String payment_type;
     
     @JsonIgnore
     @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
     @JoinColumn(name = "product_id",referencedColumnName = "id")
     private ProductEntity products;
	

	   @OneToOne(cascade = CascadeType.ALL)
	   @JoinColumn(name="adddress_id",nullable = false,referencedColumnName = "id")
     private ShippingAddressEntity addressList;


		public OrdersEntity() {
			//No-arg Constructor
		}


		public OrdersEntity(LocalDate order_Date, LocalTime order_Time, Long orderTotal, String payment_type,
				ProductEntity products, ShippingAddressEntity addressList) {
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


		public ProductEntity getProducts() {
			return products;
		}


		public void setProducts(ProductEntity products) {
			this.products = products;
		}


		public ShippingAddressEntity getAddressList() {
			return addressList;
		}


		public void setAddressList(ShippingAddressEntity addressList) {
			this.addressList = addressList;
		}


		@Override
		public String toString() {
			return "OrdersEntity [id=" + id + ", order_Date=" + order_Date + ", order_Time=" + order_Time
					+ ", orderTotal=" + orderTotal + ", payment_type=" + payment_type + ", products=" + products
					+ ", addressList=" + addressList + "]";
		}
				}
			
			


			

