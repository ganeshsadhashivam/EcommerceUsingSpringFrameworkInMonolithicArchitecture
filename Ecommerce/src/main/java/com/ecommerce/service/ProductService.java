package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	public List<Product> getAllProducts()
	{
		return dao.getAllProducts();
		
	}
	
	
	public Product getProductById(int id)
	{
		return dao.getProductById(id);
	}
	
	public void addProduct(Product product)
	{
		dao.addProduct(product);
	}
	
	public boolean deleteProductById(int id)
	{
		return dao.deleteProductById(id);
	}
	
	public boolean updateProduct(int id,Product updateProduct)
	{
		return dao.updateProduct(id, updateProduct);
	}
}
