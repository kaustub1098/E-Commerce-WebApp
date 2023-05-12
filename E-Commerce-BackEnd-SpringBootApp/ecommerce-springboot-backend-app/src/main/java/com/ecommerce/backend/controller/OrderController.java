package com.ecommerce.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.dto.OrdersDTO;
import com.ecommerce.backend.services.OrdersService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/v1")

public class OrderController {

	
	private OrdersService ordersService;
	
	public OrderController(@Autowired OrdersService ordersService) {
		this.ordersService=ordersService;
	}
	
	@GetMapping(value = "/status", produces = "plain/text")
	@ApiOperation(value = "Returns Status",
	  notes = "This method creates returns the status ok for rest endpoint")
	public String getStatus() {
		return "Health status - OK from UserController";
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/orders")
	public ResponseEntity<List<OrdersDTO>>getOrderList(){
		List<OrdersDTO> list= this.ordersService.getOrdersList();
		return new ResponseEntity<List<OrdersDTO>>(list, HttpStatus.OK);
	}
	
	

	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping(value = "/orders", consumes = "application/json", produces = "application/json")
	public ResponseEntity<OrdersDTO> createNewOrder(@RequestBody OrdersDTO newOrder){
		OrdersDTO returnOrdersDTO = this.ordersService.saveOrders(newOrder);
		return new ResponseEntity<OrdersDTO>(returnOrdersDTO,HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/orders/name/{name}")
	public ResponseEntity<List<OrdersDTO>> searchOrdersByProductName(@PathVariable ("name")String name){
		List<OrdersDTO>listOrdersDTO=this.ordersService.getOrderByProductName(name);
		return ResponseEntity.ok(listOrdersDTO);
	}

	
	

	
}


