package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.utils.BankConnection;


public class CustomerDao implements CustomerDaoInterface{

	@Override
	public List<Customer> getCustomers() {
		//connect to database
		try(Connection conn = BankConnection.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from bank.customers";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Customer> customerList = new ArrayList<Customer>();
			
			while(rs.next()) {
			Customer c = new Customer(
					rs.getInt("customer_id"),
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getDouble("account_bal"),
					rs.getInt("account_num_fk")
					);
			
			customerList.add(c);
			}
			
			return customerList;
			
		} catch(SQLException e) {
			System.out.println("Something went wrong with the database.");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void addCustomer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer() {
		// TODO Auto-generated method stub
		
	}

}
