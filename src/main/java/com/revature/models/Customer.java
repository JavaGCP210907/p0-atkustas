package com.revature.models;

public class Customer {
	
	//variables
	private int customer_id;
	private String firstname;
	private String lastname;
	private double account_bal;
	private int account_num;


	//constructors
	public Customer() {
	}
	
	public Customer(int customer_id, String firstname, String lastname, double account_bal, int account_num) {
		super();
		this.customer_id = customer_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.account_bal = account_bal;
		this.account_num = account_num;
	}

	public Customer(int customer_id, String firstname, String lastname, int account_bal) {
		super();
		this.customer_id = customer_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.account_bal = account_bal;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", account_bal=" + account_bal + ", account_num=" + account_num + "]";
	}
	
	//getters & setters
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getAccount_bal() {
		return account_bal;
	}

	public void setAccount_bal(int account_bal) {
		this.account_bal = account_bal;
	}

	public int getAccount_num() {
		return account_num;
	}

	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(account_bal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + account_num;
		result = prime * result + customer_id;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
		Customer other = (Customer) obj;
		if (Double.doubleToLongBits(account_bal) != Double.doubleToLongBits(other.account_bal))
			return false;
		if (account_num != other.account_num)
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
	

	

}
