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

import com.ecommerce.backend.dto.ShippingAddressDTO;
import com.ecommerce.backend.entities.ShippingAddressEntity;
import com.ecommerce.backend.repository.ShippingAddressRespository;
import com.ecommerce.backend.services.ShippingAddressService;

@ExtendWith(MockitoExtension.class)
public class ShippingAddressServiceUnitTests {

	@Mock
	private ShippingAddressRespository shippingAddressRespository;
	
	@InjectMocks
	private ShippingAddressService shippingAddressService;
	
	@DisplayName("Junit test for getting Shipping Address")
	@Test
	public void givenShippingAddress_whenGetAllAddress_thenGetAddressList() {
		
		
		//given-precondition or setup
		ShippingAddressEntity address1 = new ShippingAddressEntity("Tom", "Cruise", 483982,32438, 2322, "Long Beach","Miami ","LA", "USA");
		
		ShippingAddressEntity address2 = new ShippingAddressEntity("Jack", "Cruise", 483982,32438, 2322, "Long Beach","Miami ","LA", "USA");
		
		//given
		BDDMockito.given(shippingAddressRespository.findAll()).willReturn(List.of(address1,address2));
		
		//when
		List<ShippingAddressDTO> addressList= shippingAddressService.findAll();
		
		
		//then
		Assertions.assertThat(addressList).isNotNull();
		Assertions.assertThat(addressList.size()).isEqualTo(2);
		
		
	}
	
	/*
	@DisplayName("Junit test for saving Shipping Address")
	@Test
	public void giveShipAddressObject_whenSaved_thenNewSavedShipAddressObject() {
		
		//given
		ShippingAddressEntity address1 = new ShippingAddressEntity("Tom", "Cruise", 483982,32438, 2322, "Long Beach","Miami ","LA", "USA");
		
		
		//given
		BDDMockito.given(shippingAddressRespository.save(address1)).willReturn(address1);
		
		//when
		ShippingAddressDTO saveAddress = shippingAddressService.saveAddress(address1);
		
		//assertions
	
		Assertions.assertThat(saveAddress).isNotNull();
	}*/
	
}