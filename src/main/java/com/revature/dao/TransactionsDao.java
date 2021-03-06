package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.revature.models.Transaction;
import com.revature.utils.BankConnection;


public class TransactionsDao implements TransactionsDaoInterface{
	
	@Override
	public List<Transaction> getTrans() {
try(Connection conn = BankConnection.getConnection()){
			
			//initialize empty ResultSet object. Will store results from database
			ResultSet rs = null;
			
			//write SQL query, store to String
			String sql = "select * from bank.transactions";
			
			//put SQL query into Statement object
			Statement s = conn.createStatement();
			
			//execute query, put results in ResultSet object
			rs = s.executeQuery(sql);
			
			//create empty list to fill with database data
			List<Transaction> transactionList = new ArrayList<>();
			
			while(rs.next()) {
				//while there are results in the results set
				
				//create new Employee object from the returned row
				Transaction t = new Transaction(
						//use get___ for each column in the record
						rs.getInt("account_num"),
						rs.getString("tran_type"),
						rs.getDouble("tran_amt"),
						rs.getString("tran_date")
						);
				
				//populate ArrayList with each new Employee object
				transactionList.add(t);
			}
			
			//when there are no more results in the ResultSet, the while loop will end
			return transactionList;
			
		} catch(SQLException e) {
			System.out.println("Something went wrong with the database.");
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void makeDepositByAccount(double amt, int id) {
		
		try(Connection conn = BankConnection.getConnection()){
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = new Date();
			
			String currentDate = dateFormat.format(date);
			
			String type = "Deposit";
			
			String sql = "update bank.transactions set tran_type = ?, tran_amt = ?,"
					+ " tran_date = ? where account_num = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, type);
			ps.setDouble(2, amt);
			ps.setDate(3, java.sql.Date.valueOf(currentDate));
			ps.setInt(4, id);
			
			ps.executeUpdate();
			
			System.out.println("Deposit of " +amt+ " added to account # " + id +".");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong, funds not deposited.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void makeWithdrawalByAccount(double amt, int id) {
		
		try(Connection conn = BankConnection.getConnection()){
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = new Date();
			
			String currentDate = dateFormat.format(date);
			
			String type = "Withdrawal";
			
			String sql = "update bank.transactions set tran_type = ?, tran_amt = ?,"
					+ " tran_date = ? where account_num = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, type);
			ps.setDouble(2, amt);
			ps.setDate(3, java.sql.Date.valueOf(currentDate));
			ps.setInt(4, id);
			
			System.out.println("Withdrawal of " +amt+ " taken from account # " + id +".");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong, funds not withdrawn.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void addNewAccount(double amt) {
		
		try(Connection conn = BankConnection.getConnection()){
			
			//fetch current date in correct format
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			//from java.util will be converted to java.sql Date
			Date date = new Date();
			
			//sets date to correct format
			String currentDate = dateFormat.format(date);
			
			String sql = "insert into bank.transactions (tran_type, tran_amt, tran_date)" +
							"values (?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "Deposit");
			ps.setDouble(2, amt);
			ps.setDate(3, java.sql.Date.valueOf(currentDate));
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Something went wrong, account not created.");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteAccount(int id) {
		
		try(Connection conn = BankConnection.getConnection()){
			
			//DELETE
			String sql = "delete from bank.transactions where account_num = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Account removal failed.");
			e.printStackTrace();
		}
		
	}



}
