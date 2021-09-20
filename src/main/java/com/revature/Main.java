package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu;
import com.revature.utils.BankConnection;


public class Main {

	public static void main(String[] args) {
		//try with resources block
		try(Connection conn = BankConnection.getConnection()){
			System.out.println("Hello, connection was successful.");
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		
		Menu m = new Menu();
		m.printMenu();

	}

}
