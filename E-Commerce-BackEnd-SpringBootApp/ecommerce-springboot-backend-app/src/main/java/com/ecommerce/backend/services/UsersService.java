package com.ecommerce.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.dto.UsersDTO;
import com.ecommerce.backend.entities.UsersEntity;
import com.ecommerce.backend.repository.UsersRepository;

@Service
public class UsersService {
	
	private UsersRepository usersRepository;
	
	public UsersService(@Autowired UsersRepository usersRepository) {
		this.usersRepository=usersRepository;
	}
	
	public UsersDTO saveUser(UsersDTO users) {
		
		ModelMapper mapper= new ModelMapper();
		UsersEntity usersEntity = mapper.map(users, UsersEntity.class);
		UsersEntity returnedUsersEntity = this.usersRepository.save(usersEntity);
		UsersDTO returneUsersDTO = mapper.map(returnedUsersEntity, UsersDTO.class);
		return returneUsersDTO;
	}
	
	public List<UsersDTO> getAllUser(){
		
		ModelMapper mapper  = new ModelMapper();
		Iterable<UsersEntity> listUserEntity = this.usersRepository.findAll();
		
		List<UsersDTO>listUsersDTO= new ArrayList<>();
		for (UsersEntity usersEntity : listUserEntity) {
			UsersDTO usersDTO=mapper.map(usersEntity,UsersDTO.class);
			listUsersDTO.add(usersDTO);
		}
		return listUsersDTO;
		}
	
	 public void deleteUserByName(String name) {
		 this.usersRepository.deleteUserByName(name);
		 
		}
	 
	 
	 public List<UsersDTO>getUserByName(String name){
	        List <UsersEntity>listUserEntity= this.usersRepository.showByUserName(name);
	        List<UsersDTO>listUserDTO = new ArrayList<UsersDTO>();

	        ModelMapper mapper= new ModelMapper();
	        for(UsersEntity usersEntity :listUserEntity) {
	            UsersDTO tempDto=mapper.map(usersEntity, UsersDTO.class);
	            listUserDTO.add(tempDto);

	        }
	        return listUserDTO;

	    }

	
	
	

}
