package com.ecommerce.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.dto.ShippingAddressDTO;
import com.ecommerce.backend.services.ShippingAddressService;

@RestController
@RequestMapping("/api/v1")
public class ShippingAddressController {
	
	private ShippingAddressService shippingAddressService;
	
	
	public ShippingAddressController(@Autowired ShippingAddressService shippingAddressService) {
		this.shippingAddressService=shippingAddressService;
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/shippingAddress")
	public ResponseEntity<List<ShippingAddressDTO>> getShippingAddress(){
		List<ShippingAddressDTO> list =this.shippingAddressService.findAll();
		return new ResponseEntity<List<ShippingAddressDTO>>(list,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping(value = "/shippingAddress",consumes = "application/json",produces = "application/json")
	public ResponseEntity<ShippingAddressDTO>saveShipppingAddress(@RequestBody ShippingAddressDTO address){
		
		ShippingAddressDTO returnedShippingAddressDTO =this.shippingAddressService.saveAddress(address);
		return new ResponseEntity<ShippingAddressDTO>(returnedShippingAddressDTO, HttpStatus.CREATED);
		
	}
	
	

	
	
	
	
	
	
}
