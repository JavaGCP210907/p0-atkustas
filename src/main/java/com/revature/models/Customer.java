package com.revature.models;

public class Customer {
	
	//variables
	private int customer_id;
	private String firstName;
	private String lastName;
	private String address;
	private double account_bal;
	private int account_num_fk;


	//constructors
	public Customer() {
	}
	
	public Customer(String firstName, String lastName, String address, double account_bal) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.account_bal = account_bal;
	}

	public Customer(int customer_id, String firstName, String lastName, String address, double account_bal, int account_num_fk) {
		super();
		this.customer_id = customer_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.account_bal = account_bal;
		this.account_num_fk = account_num_fk;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", account_bal=" + account_bal + ", account_num=" + account_num_fk + "]";
	}
	
	//getters & setters
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAccount_bal() {
		return account_bal;
	}

	public void setAccount_bal(double account_bal) {
		this.account_bal = account_bal;
	}

	public int getAccount_num() {
		return account_num_fk;
	}

	public void setAccount_num(int account_num_fk) {
		this.account_num_fk = account_num_fk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(account_bal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + account_num_fk;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + customer_id;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (account_num_fk != other.account_num_fk)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	

}