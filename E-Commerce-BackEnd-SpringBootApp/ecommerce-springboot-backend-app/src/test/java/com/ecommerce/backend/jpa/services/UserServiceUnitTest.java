package com.ecommerce.backend.jpa.services;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.backend.dto.UsersDTO;
import com.ecommerce.backend.entities.UsersEntity;
import com.ecommerce.backend.repository.UsersRepository;
import com.ecommerce.backend.services.UsersService;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {
	
	@Mock
	private UsersRepository usersRepository;

	@InjectMocks
	private UsersService usersService;
	
	@DisplayName("Junit test for getting all Users")
	@Test
	public void givenUserList_whenGetAllUsers_thenGetUsersList() {
		
		//given-preCondition or setup
		
		UsersEntity user1= new UsersEntity("Tom", "Cruise", "Long Beach", "tom@gmail.com", "tom@2023", "19238");
		
		
		UsersEntity user2= new UsersEntity("Tom", "Cruise", "Long Beach", "tom@gmail.com", "tom@2023", "19238");
		
		//given
		BDDMockito.given(usersRepository.findAll()).willReturn(List.of(user1,user2));
		
		//when
		List<UsersDTO>userList = usersService.getAllUser();
		
		//then
		Assertions.assertThat(userList).isNotNull();
		Assertions.assertThat(userList.size()).isEqualTo(2);
		
	}
	
	@DisplayName("Junit test for getting User name")
	@Test
	public void givenUserList_whenGetUserByName_thenGetUserList() {
		
		//given-precondition or setup
		UsersEntity user1= new UsersEntity("Tom", "Cruise", "Long Beach", "tom@gmail.com", "tom@2023", "19238");
		

		UsersEntity user2= new UsersEntity("Jack", "Cruise", "Long Beach", "tom@gmail.com", "tom@2023", "19238");
		
		
		//given
		BDDMockito.given(usersRepository.showByUserName("Tom")).willReturn(List.of(user1));
		
		//when
		List<UsersDTO>userList =usersService.getUserByName("Tom");
		
		//then
		Assertions.assertThat(userList).isNotNull();
		
			
	}
		
	
}
