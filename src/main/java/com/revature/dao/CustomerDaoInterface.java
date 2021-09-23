package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDaoInterface {
	
	//SELECT *
	public List<Customer> getCustomers();
	
	//SELECT WHERE
	public List<Customer> getCustomerById(int id);
	
	//INSERT
	public void addCustomer(Customer customer);
	
	//DELETE
	public void removeCustomer(int id);
	
	//UPDATE
	public void updateDeposit(double amt, int id);
	
	//UPDATE
	public void updateWithdrawal(double amt, int id);

}
