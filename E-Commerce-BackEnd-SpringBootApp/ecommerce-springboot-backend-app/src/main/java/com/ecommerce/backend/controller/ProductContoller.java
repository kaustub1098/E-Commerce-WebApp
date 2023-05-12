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

import com.ecommerce.backend.dto.ProductDTO;
import com.ecommerce.backend.services.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductContoller {

	
	private ProductService productService;
	public ProductContoller(@Autowired ProductService productService) 
	{
		this.productService=productService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getProductList(){
		   List<ProductDTO> list = this.productService.getAllProducts();
	        return new ResponseEntity<List<ProductDTO>>(list,HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	  @PostMapping(value = "/products", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO product) {
	       
	        ProductDTO returnedProductDTO =   this.productService.saveProduct(product);
	        return new ResponseEntity<ProductDTO>(returnedProductDTO, HttpStatus.CREATED);
	    }
	
	
	
	  @CrossOrigin(origins = "http://localhost:4200/")
	    @GetMapping("/products/name/{name}")
	    public ResponseEntity<List<ProductDTO>> getProductByName(@PathVariable("name") String name)
	    {
	    	List<ProductDTO> listProductDTO=this.productService.getProductByName(name);
	    	return ResponseEntity.ok(listProductDTO);
	    	
	    }
	  
	  
	  @CrossOrigin(origins = "http://localhost:4200/")
	    @DeleteMapping("/products/{name}")
		public ResponseEntity<List<ProductDTO>> deleteProduct(@PathVariable("name") String productName) 
		{
	    	List<ProductDTO> listProductDTO=this.productService.getProductByName(productName);

	    	if(listProductDTO !=null)
	    	{
	    		this.productService.deleteProductByName(productName);
	    	}
	    	else
	    	{
	    		System.err.println("Cannot found the name of product");	
	    	}
			   return null;
		    }
	  
	  
	  
	  
	
	
}
