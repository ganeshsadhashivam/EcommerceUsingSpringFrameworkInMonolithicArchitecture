package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.config.DBConfig;
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
		List<Product> products = new ArrayList<>();
		
		String query = "select * from products";
		
		try
		{
		Connection con = DBConfig.getConnection();
		
		PreparedStatement	ps = 	con.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			Product product =
                    new Product();

            product.setId(
                    rs.getInt("id")
            );

            product.setName(
                    rs.getString("name")
            );

            product.setPrice(
                    rs.getDouble("price")
            );

            products.add(product);
		}
		}
		catch(Exception e) {

	        e.printStackTrace();
	    }
		return products;
	}
	
	
//	public Product getProductById(int id)
//	{
//		for(Product p : products)
//		{
//			if(p.getId()==id)
//			{
//				return p;
//			}
//		}
//		
//		return null;
//	}
	public Product getProductById(int id)
	{
		Product product = null;
		
		String query = "select * from products where id=?";
		try
		{
			Connection con = DBConfig.getConnection();
			
			PreparedStatement  ps  = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				product = new Product();
				
				product.setId(rs.getInt("id"));
				
				product.setName(rs.getString("name"));
				
				product.setPrice(rs.getDouble("price"));
			}
		}
		 catch(Exception e) {

		        e.printStackTrace();
		    }
		
		return product;
	}
	
	
	public void addProduct(Product product)
	{
//		products.add(product);
		
		String query = "insert into products values (?,?,?)";
		
		try
		{
			Connection con = DBConfig.getConnection();
			
			PreparedStatement  ps  = con.prepareStatement(query);
			
			ps.setInt(1,product.getId());
			
			ps.setString(2, product.getName());
			
			ps.setDouble(3, product.getPrice());
			
			ps.executeUpdate();
			
			System.out.println(
	                "Product Inserted Successfully"
	        );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
//	public boolean deleteProductById(int id)
//	{
//		for(Product p : products)
//		{
//			if(p.getId()==id)
//			{
//				products.remove(p);
//				
//				return true;
//			}
//		}
//		
//		return false;
//	}
	
	public boolean deleteProductById(int id)
	{
		String query = "delete from products where id=?";
		
		try
		{
			Connection con = DBConfig.getConnection();
			
			PreparedStatement  ps  = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected>0)
			{
				return true;
			}
		}
		 catch(Exception e) {

		        e.printStackTrace();
		    }
		
		return false;
	}
	
	
//	public boolean updateProduct(int id,Product updateProduct)
//	{
//		for(Product p : products)
//		{
//			if(p.getId()==id)
//			{
//				p.setName(updateProduct.getName());
//				p.setPrice(updateProduct.getPrice());
//				
//				return true;
//			}
//		}
//		return false;
//	}
	
	public boolean updateProduct(int id,Product updateProduct)
	{
		String query  =  "UPDATE products SET name = ?, price = ? WHERE id = ?";
		
		try
		{
	       Connection con = DBConfig.getConnection();
			
			PreparedStatement  ps  = con.prepareStatement(query);
			
			ps.setString(1, updateProduct.getName());
			
			ps.setDouble(2, updateProduct.getPrice());
			
			ps.setInt(3, id);
			
			 int rowsAffected =
		                ps.executeUpdate();

		        if(rowsAffected > 0) {

		            return true;
		        }
		}
		catch(Exception e) {

	        e.printStackTrace();
	    }
		return false;
	}
	
	
	

}
