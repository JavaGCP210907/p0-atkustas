package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
					rs.getString("firstName"),
					rs.getString("lastName"),
					rs.getString("address"),
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
	public void addCustomer(Customer customer) {

		try(Connection conn = BankConnection.getConnection()){
			
			String sql = "insert into bank.customers (firstname, lastname, address, account_bal)" +
							"values (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getAddress());
			ps.setDouble(4, customer.getAccount_bal());
			
			ps.executeUpdate();
			
			System.out.println("New customer " +customer.getFirstName()+ " entered into system.");
			System.out.println(customer.getFirstName()+ " initial balance: " +customer.getAccount_bal());
			
			
		} catch(SQLException e) {
			System.out.println("add employee failed.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}
