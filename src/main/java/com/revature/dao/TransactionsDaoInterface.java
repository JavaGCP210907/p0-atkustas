package com.revature.dao;

import java.util.List;

import com.revature.models.Transaction;

public interface TransactionsDaoInterface {
	
	public List<Transaction> getTrans();
	
	public void makeDepositByAccount(int id, int deposit);
	
	public void makeWithdrawalByAccount(int id, int withdrawal);
	
	public void addNewAccount(double amt);

}
