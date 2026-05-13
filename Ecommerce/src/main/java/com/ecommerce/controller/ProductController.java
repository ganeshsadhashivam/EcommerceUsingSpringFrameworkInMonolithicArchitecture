package com.ecommerce.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public List<Product> getProducts()
	{
		return service.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") int id)
	{
		return service.getProductById(id);
	}
	
	@PostMapping("/products")
	public String addProduct(@RequestBody Product product)
	{
		service.addProduct(product);
		return "Product Added Successfully";
	}
	
	
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable("id") int id)
	{
		boolean deleted = service.deleteProductById(id);
		
		if(deleted)
		{
			return "Product deleted Successfully";
		}
		
		return "Product Not Found";
	}
	
	
	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable("id")int id,@RequestBody Product product)
	{
		boolean updated = service.updateProduct(id, product);
		
		if(updated)
		{
			return "Product updated Successfully";
		}
		
		return "Product updation Failed";
	}
}
