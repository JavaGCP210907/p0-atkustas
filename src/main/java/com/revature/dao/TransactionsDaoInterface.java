package com.revature.dao;

import java.util.List;

import com.revature.models.Transaction;

public interface TransactionsDaoInterface {
	
	//SELECT *
	public List<Transaction> getTrans();
	
	//UPDATE
	public void makeDepositByAccount(double amt, int id);
	
	//UPDATE
	public void makeWithdrawalByAccount(double amt, int id);
	
	//INSERT
	public void addNewAccount(double amt);
		
	//DELETE
	public void deleteAccount(int id);

}
