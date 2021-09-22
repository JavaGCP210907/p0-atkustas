package com.revature.models;

public class Transaction {
	
	//variables
	private int account_num;
	private String tran_type;
	private double tran_amt;
	private String tran_date;

	//constructors
	public Transaction() {
		super();
	}

	public Transaction(int account_num, String tran_type, double tran_amt, String tran_date) {
		super();
		this.account_num = account_num;
		this.tran_type = tran_type;
		this.tran_amt = tran_amt;
		this.tran_date = tran_date;
	}
	
	@Override
	public String toString() {
		return "Transaction [account_num=" + account_num + ", tran_type=" + tran_type + ", tran_amt=" + tran_amt
				+ ", tran_date=" + tran_date + "]";
	}

	public int getAccount_num() {
		return account_num;
	}

	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}

	public String getTran_type() {
		return tran_type;
	}

	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}

	public double getTran_amt() {
		return tran_amt;
	}

	public void setTran_amt(double tran_amt) {
		this.tran_amt = tran_amt;
	}

	public String getTran_date() {
		return tran_date;
	}

	public void setTran_date(String tran_date) {
		this.tran_date = tran_date;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_num;
		long temp;
		temp = Double.doubleToLongBits(tran_amt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tran_date == null) ? 0 : tran_date.hashCode());
		result = prime * result + ((tran_type == null) ? 0 : tran_type.hashCode());
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
		if (Double.doubleToLongBits(tran_amt) != Double.doubleToLongBits(other.tran_amt))
			return false;
		if (tran_date == null) {
			if (other.tran_date != null)
				return false;
		} else if (!tran_date.equals(other.tran_date))
			return false;
		if (tran_type == null) {
			if (other.tran_type != null)
				return false;
		} else if (!tran_type.equals(other.tran_type))
			return false;
		return true;
	}
	
	
}
