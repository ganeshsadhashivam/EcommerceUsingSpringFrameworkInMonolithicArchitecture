package com.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Product;

@Repository
public class ProductDAO {

	private List<Product> products = new ArrayList<>();
	
	public ProductDAO() {

        products.add(new Product(1, "Laptop", 55000));
        products.add(new Product(2, "Phone", 25000));
        products.add(new Product(3, "Headphones", 3000));

    }
	
	public List<Product> getAllProducts()
	{
		return products;
	}
	
	
	public Product getProductById(int id)
	{
		for(Product p : products)
		{
			if(p.getId()==id)
			{
				return p;
			}
		}
		
		return null;
	}
	
	
	public void addProduct(Product product)
	{
		products.add(product);
	}
	
	
	public boolean deleteProductById(int id)
	{
		for(Product p : products)
		{
			if(p.getId()==id)
			{
				products.remove(p);
				
				return true;
			}
		}
		
		return false;
	}
	
	
	public boolean updateProduct(int id,Product updateProduct)
	{
		for(Product p : products)
		{
			if(p.getId()==id)
			{
				p.setName(updateProduct.getName());
				p.setPrice(updateProduct.getPrice());
				
				return true;
			}
		}
		return false;
	}
	
	
	

}
