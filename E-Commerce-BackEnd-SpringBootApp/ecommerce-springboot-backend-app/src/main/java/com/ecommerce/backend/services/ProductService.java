package com.ecommerce.backend.services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.backend.dto.ProductDTO;
import com.ecommerce.backend.repository.ProductRepository;
import com.ecommerce.backend.entities.ProductEntity;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	public ProductService(@Autowired ProductRepository productRepository) {
		
		this.productRepository=productRepository;
		
	}
	
	public ProductDTO saveProduct(ProductDTO product)
	{
		 ModelMapper mapper= new ModelMapper();
		ProductEntity productEntity=mapper.map(product,ProductEntity.class); 
		 ProductEntity returnedProductEntity=this.productRepository.save(productEntity);
		 ProductDTO returnedProductDTO=mapper.map(returnedProductEntity,ProductDTO.class);
		 
		 return returnedProductDTO;
		 
	}

	
	public List<ProductDTO> getAllProducts()
	{	
		ModelMapper mapper=new ModelMapper();
		Iterable<ProductEntity> listProductEntity=this.productRepository.findAll();
		
		List<ProductDTO> listProductDTO=new ArrayList<>();
		for(ProductEntity productEntity:listProductEntity)
		{
			System.out.println(productEntity);
			ProductDTO productDTO=mapper.map(productEntity,ProductDTO.class);
			listProductDTO.add(productDTO);
			}
		
		return listProductDTO;
		
	}

	public void deleteProductByName(String name) {
		this.productRepository.deleteByName(name);
	}
	
	
	public List<ProductDTO>getProductByName(String name)
	{
		List<ProductEntity> listProductEntities=this.productRepository.showByName(name);
		
		
		List<ProductDTO> listProductDTO=new ArrayList<ProductDTO>();
		
		ModelMapper model= new ModelMapper();
		
		for(ProductEntity productEntity:listProductEntities)
		{
			ProductDTO tempDTO=model.map(productEntity, ProductDTO.class);
			
			listProductDTO.add(tempDTO);
		}
	return listProductDTO;
	}
	
	
	
	
	
	
	
	

}
