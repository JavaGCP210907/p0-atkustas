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
			
			//SELECT
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
					rs.getInt("account_num")
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
	public List<Customer> getCustomerById(int id) {
		
		try(Connection conn = BankConnection.getConnection()){
			
			ResultSet rs = null;
			
			//SELECT -> WHERE
			String sql = "select * from bank.customers where customer_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			List<Customer> customerList = new ArrayList<>();
			
			while(rs.next()) {
				Customer c = new Customer(
						rs.getInt("customer_id"),
						rs.getString("firstName"),
						rs.getString("lastName"),
						rs.getString("address"),
						rs.getDouble("account_bal"),
						rs.getInt("account_num")
						);
				
				customerList.add(c);
				
			}
			
			return customerList;
			
		} catch(SQLException e) {
			System.out.println("Something went wrong fetching customer from database.");
			System.out.println("Check the customer id number and try again.");
			e.printStackTrace();
		}		
		
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {

		try(Connection conn = BankConnection.getConnection()){
			
			//INSERT
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
	public void removeCustomer(int id) {
		
		try(Connection conn = BankConnection.getConnection()){
			
			//DELETE
			String sql = "delete from bank.customers where customer_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
			System.out.println("Customer " +id+ " removed.");
			
		} catch(SQLException e) {
			System.out.println("remove employee failed.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateDeposit(double amt, int id) {

		try(Connection conn = BankConnection.getConnection()){
			
			//UPDATE
			String sql = "update bank.customers set account_bal = account_bal + ? where account_num = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, amt);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("account balance update failed.");
			e.printStackTrace();
		
		}

	}

	@Override
	public void updateWithdrawal(double amt, int id) {
		
	try(Connection conn = BankConnection.getConnection()){
			
			//UPDATE
			String sql = "update bank.customers set account_bal = account_bal - ? where account_num = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, amt);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("account balance update failed.");
			e.printStackTrace();
		
		}
		
	}
	
}
