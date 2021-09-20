package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankConnection {
	
	public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:postgresql://localhost:5432/postgres?currentScheme=bank";
		String username = "postgres";
		String password = "password";
		
		//return statement produces database Connection object
		return DriverManager.getConnection(url, username, password);
	}

}
