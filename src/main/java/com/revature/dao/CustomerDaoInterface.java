package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDaoInterface {
	
	//SELECT *
	public List<Customer> getCustomers();
	
	//INSERT
	public void addCustomer();
	
	//DELETE
	public void removeCustomer();

}
