package com.ecommerce.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.dto.UsersDTO;
import com.ecommerce.backend.entities.UsersEntity;
import com.ecommerce.backend.services.UsersService;

@RestController
@RequestMapping("/api/v2")
public class UserController {
	
	private UsersService usersService;
	
	public UserController(@Autowired UsersService userserService) {
		this.usersService=userserService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/users")
	public ResponseEntity<List<UsersDTO>>getUsers(){
		List<UsersDTO>list = this.usersService.getAllUser();
		return new ResponseEntity<List<UsersDTO>>(list, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UsersDTO>createUser(@RequestBody UsersDTO user){
		UsersDTO returnUsersDTO=this.usersService.saveUser(user);
		return new  ResponseEntity<UsersDTO>(returnUsersDTO, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/users/{name}")
    public ResponseEntity<List<UsersDTO>>deleteUserByName (@PathVariable("name")String userName){

        List<UsersDTO>listUsersDTO =this.usersService.getUserByName(userName);
        if(listUsersDTO!=null) {
            this.usersService.deleteUserByName(userName);

        }
        else {
            System.err.println("Cannot find user name");
        }
        return null;

    }

	
	
	
	

}
