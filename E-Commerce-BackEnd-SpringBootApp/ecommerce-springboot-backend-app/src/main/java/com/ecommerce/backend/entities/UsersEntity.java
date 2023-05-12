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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="users")

public class UsersEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="first_name",nullable = false)
	private String user_firstName;
	
	@Column(name="last_name",nullable = false)
	private String user_lastName;
	
	@Column(name="address",nullable = false)
	private String user_address;
	
	@Column(name="emailId",nullable = false)
	private String user_emailid;
	
	@Column(name="password",nullable = false)
	private String user_password;
	
	@Column(name = "phoneNumber",nullable = false)
	private String user_phoneNumber;

	public UsersEntity() {
		// No-Arg Constructor
	}

	public UsersEntity(String user_firstName, String user_lastName, String user_address, String user_emailid,
			String user_password, String user_phoneNumber) {
		super();
		this.user_firstName = user_firstName;
		this.user_lastName = user_lastName;
		this.user_address = user_address;
		this.user_emailid = user_emailid;
		this.user_password = user_password;
		this.user_phoneNumber = user_phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_firstName() {
		return user_firstName;
	}

	public void setUser_firstName(String user_firstName) {
		this.user_firstName = user_firstName;
	}

	public String getUser_lastName() {
		return user_lastName;
	}

	public void setUser_lastName(String user_lastName) {
		this.user_lastName = user_lastName;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_emailid() {
		return user_emailid;
	}

	public void setUser_emailid(String user_emailid) {
		this.user_emailid = user_emailid;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_phoneNumber() {
		return user_phoneNumber;
	}

	public void setUser_phoneNumber(String user_phoneNumber) {
		this.user_phoneNumber = user_phoneNumber;
	}

	@Override
	public String toString() {
		return "UsersEntity [id=" + id + ", user_firstName=" + user_firstName + ", user_lastName=" + user_lastName
				+ ", user_address=" + user_address + ", user_emailid=" + user_emailid + ", user_password="
				+ user_password + ", user_phoneNumber=" + user_phoneNumber + "]";
	}
	
}
