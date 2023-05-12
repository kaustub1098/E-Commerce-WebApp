package com.ecommerce.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.dto.ShippingAddressDTO;
import com.ecommerce.backend.entities.ShippingAddressEntity;
import com.ecommerce.backend.repository.ShippingAddressRespository;

@Service
public class ShippingAddressService {
	
	private ShippingAddressRespository shippingAddressRespository;
	
	public ShippingAddressService(@Autowired ShippingAddressRespository shippingAddressRespository) {
		this.shippingAddressRespository=shippingAddressRespository;
	}
	
	public ShippingAddressDTO saveAddress (ShippingAddressDTO address) {
		ModelMapper mapper = new ModelMapper();
		ShippingAddressEntity shippingAddressEntity = mapper.map(address, ShippingAddressEntity.class);
		ShippingAddressEntity returnedShippingAddress=this.shippingAddressRespository.save(shippingAddressEntity);
		ShippingAddressDTO returnedShippingAddressDTO=mapper.map(returnedShippingAddress, ShippingAddressDTO.class);
		
		return returnedShippingAddressDTO;
		
	}
	
	
	public List<ShippingAddressDTO>findAll(){
		ModelMapper mapper =new ModelMapper();
		Iterable<ShippingAddressEntity> listofAddress = this.shippingAddressRespository.findAll();
		
		List<ShippingAddressDTO>listShippingAddressDTOs = new ArrayList<>();
		for (ShippingAddressEntity shippingAddressEntity : listofAddress) {
			ShippingAddressDTO shippingAddressDTO =mapper.map(shippingAddressEntity, ShippingAddressDTO.class);
			listShippingAddressDTOs.add(shippingAddressDTO);
		}
		return listShippingAddressDTOs;
		
		
		
	}
	

}
