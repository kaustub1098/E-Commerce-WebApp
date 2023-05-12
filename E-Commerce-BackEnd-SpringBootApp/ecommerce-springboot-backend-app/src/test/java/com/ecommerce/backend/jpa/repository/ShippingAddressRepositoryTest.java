package com.ecommerce.backend.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.ecommerce.backend.entities.ShippingAddressEntity;
import com.ecommerce.backend.repository.ShippingAddressRespository;

@ActiveProfiles("test")
@DataJpaTest
public class ShippingAddressRepositoryTest {
	@Autowired
	private ShippingAddressRespository shippingAddressRespository;
	
	
	@DisplayName("Junit Test case for saving shipAddress to DB")
	@Test
	public void giveShiipingAddressObject_whenSave_thenReturnSavedShippingAddress() {
		
		//given
		ShippingAddressEntity address = new ShippingAddressEntity("Tom" , "Cruise", 2139121, 843920, 3728,"Long Beach", "California", "LA", "USA");
		
		//when
		ShippingAddressEntity newAddress = shippingAddressRespository.save(address);
		
		//then
		assertThat(newAddress).isNotNull();
		assertThat(newAddress.getId()).isGreaterThan(0); 
		
	}
	
	@DisplayName("Junit Test case for getting shipAddress List from DB")
	@Test
	public void givenShipAddressList_whenFindAll_thenShipAddressList() {
		
		//given
	    ShippingAddressEntity address = new ShippingAddressEntity("Tom" , "Cruise", 2139121, 843920, 3728,"Long Beach", "California", "LA", "USA");
	    shippingAddressRespository.save(address);
	    
	    
	    //when
	    List<ShippingAddressEntity>addressList= shippingAddressRespository.findAll();
	    

		// then - Verify the output
		assertThat(addressList).isNotNull();
		assertThat(addressList.size()).isEqualTo(1);
		
	}
	
}
