package com.ecommerce.backend.dto;


public class ShippingAddressDTO {

	
	private Long id; 
	
	private String first_name;
	
	private String last_name;
	
	private Integer mobileno;

	private Integer pincode;
	
	private Integer houseno;
	
	private String street_name;
	
	private String city;
	
	private String state;
	
	private String country;

	public ShippingAddressDTO(String first_name, String last_name, Integer mobileno, Integer pincode, Integer houseno,
			String street_name, String city, String state, String country) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobileno = mobileno;
		this.pincode = pincode;
		this.houseno = houseno;
		this.street_name = street_name;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public ShippingAddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getMobileno() {
		return mobileno;
	}

	public void setMobileno(Integer mobileno) {
		this.mobileno = mobileno;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Integer getHouseno() {
		return houseno;
	}

	public void setHouseno(Integer houseno) {
		this.houseno = houseno;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "ShippingAddressDTO [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", mobileno=" + mobileno + ", pincode=" + pincode + ", houseno=" + houseno + ", street_name="
				+ street_name + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
	
	
	
	
	
	
}
