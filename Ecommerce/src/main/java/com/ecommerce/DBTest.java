package com.ecommerce;

import java.sql.Connection;
import java.sql.SQLException;

import com.ecommerce.config.DBConfig;

public class DBTest {

	public static void main(String [] args) 
	{
		try {
			Connection  con = DBConfig.getConnection();
			System.out.println("Database Connected Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
