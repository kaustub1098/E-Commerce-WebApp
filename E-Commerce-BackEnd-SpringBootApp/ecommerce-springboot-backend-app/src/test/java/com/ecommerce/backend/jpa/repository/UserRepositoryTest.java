package com.ecommerce.backend.jpa.repository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.intThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.ecommerce.backend.entities.UsersEntity;
import com.ecommerce.backend.repository.UsersRepository;

@ActiveProfiles("test")
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UsersRepository usersRepository;
	
	
	@DisplayName("Junit Test case for saving user to DB")
	@Test
	public void giveUserObject_whenSave_thenReturnSavedUser() {
		
		//given
		UsersEntity user = new UsersEntity("Rohan","Kulkarni", "Kalyan Maharashtra", "rohanK@gmail.com", "rohan123", "298131");
		
		
		//when
		UsersEntity newUser = usersRepository.save(user);
		
		//then
		assertThat(newUser).isNotNull();
		assertThat(newUser.getId()).isGreaterThan(0);
	}
	
	
	@DisplayName("Junit Test case for getting users from DB")
	@Test
	public void giveUserList_whenFindAll_thenUsersList() {
		
		//given
		UsersEntity user = new UsersEntity("Rohan","Kulkarni", "Kalyan Maharashtra", "rohanK@gmail.com", "rohan123", "298131");
		usersRepository.save(user);
		
		//when
		List<UsersEntity> userList = usersRepository.findAll();
		
		//then
		assertThat(userList).isNotNull();
		assertThat(userList.size()).isEqualTo(1);
	}
	
	@DisplayName("Junit Test case for deleting users by name from DB")
	@Test
	public void givenDeleteUserByName_whenDelete_thenReturnUsers() {
		//given
				UsersEntity user = new UsersEntity("Rohan","Kulkarni", "Kalyan Maharashtra", "rohanK@gmail.com", "rohan123", "298131");
				usersRepository.save(user);
				
        //when
		int UserList = usersRepository.deleteUserByName("Rohan");
		
		//then
		assertThat(UserList).isNotNull();
		
	}
	
}
