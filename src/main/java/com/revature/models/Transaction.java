package com.revature.models;

public class Transaction {
	
	//variables
	private int account_num;
	private int last_deposit;
	private String last_dep_date;
	private int last_withdrawal;
	private String last_withdrawal_date;

	//constructors
	public Transaction() {
		super();
	}

	public Transaction(int account_num, int last_deposit, String last_dep_date, int last_withdrawal,
			String last_withdrawal_date) {
		super();
		this.account_num = account_num;
		this.last_deposit = last_deposit;
		this.last_dep_date = last_dep_date;
		this.last_withdrawal = last_withdrawal;
		this.last_withdrawal_date = last_withdrawal_date;
	}

	@Override
	public String toString() {
		return "Transaction [account_num=" + account_num + ", last_deposit=" + last_deposit + ", last_dep_date="
				+ last_dep_date + ", last_withdrawal=" + last_withdrawal + ", last_withdrawal_date="
				+ last_withdrawal_date + "]";
	}

	public int getAccount_num() {
		return account_num;
	}

	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}

	public int getLast_deposit() {
		return last_deposit;
	}

	public void setLast_deposit(int last_deposit) {
		this.last_deposit = last_deposit;
	}

	public String getLast_dep_date() {
		return last_dep_date;
	}

	public void setLast_dep_date(String last_dep_date) {
		this.last_dep_date = last_dep_date;
	}

	public int getLast_withdrawal() {
		return last_withdrawal;
	}

	public void setLast_withdrawal(int last_withdrawal) {
		this.last_withdrawal = last_withdrawal;
	}

	public String getLast_withdrawal_date() {
		return last_withdrawal_date;
	}

	public void setLast_withdrawal_date(String last_withdrawal_date) {
		this.last_withdrawal_date = last_withdrawal_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_num;
		result = prime * result + ((last_dep_date == null) ? 0 : last_dep_date.hashCode());
		result = prime * result + last_deposit;
		result = prime * result + last_withdrawal;
		result = prime * result + ((last_withdrawal_date == null) ? 0 : last_withdrawal_date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (account_num != other.account_num)
			return false;
		if (last_dep_date == null) {
			if (other.last_dep_date != null)
				return false;
		} else if (!last_dep_date.equals(other.last_dep_date))
			return false;
		if (last_deposit != other.last_deposit)
			return false;
		if (last_withdrawal != other.last_withdrawal)
			return false;
		if (last_withdrawal_date == null) {
			if (other.last_withdrawal_date != null)
				return false;
		} else if (!last_withdrawal_date.equals(other.last_withdrawal_date))
			return false;
		return true;
	}
	
	
	
}
