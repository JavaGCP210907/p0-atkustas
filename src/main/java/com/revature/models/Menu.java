package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.CustomerDao;
import com.revature.dao.TransactionsDao;

public class Menu {
	
	CustomerDao cDao = new CustomerDao();
	TransactionsDao tDao = new TransactionsDao();
	
	public void printMenu() {
		
		boolean printMenu = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to The Bank Management System!");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		while(printMenu) {
			System.out.println("Options Menu");
			System.out.println("Enter a command to choose an option");
			System.out.println("-----------------------------------");
			
			System.out.println("customers -->> show all customers");
			System.out.println("recenttrans -->> show latest transactions");
			System.out.println("customerbyid -->> show customer by id");
			System.out.println("makedepositbyid -->> make a deposit");
			System.out.println("newcustomer -->> add a new customer");
			System.out.println("removecustomer -->> remove customer by id");
			System.out.println("exit -->> leave app");
			
			//
			String command = sc.nextLine();
			
			switch(command) {
			case "customers":
				List<Customer> customers = cDao.getCustomers();
				for(Customer cust : customers) {
					System.out.println(cust);
				}
				
				
				break;
			
			case "recenttrans": {
				List<Transaction> transactions = tDao.getTrans();
				for(Transaction tran : transactions) {
					System.out.println(tran);
				}
				
			}
			break;
			
			case "customerbyid":
				System.out.println("Which customer id would you like a record for?");
				int input = sc.nextInt();
				sc.nextLine();
				
				List <Customer> customer = cDao.getCustomerById(input);
				for(Customer cust : customer) {
					System.out.println(cust);
				}
				break;
				
			case "newcustomer":
				
				System.out.println("Enter customer first name");
				String firstName = sc.nextLine();
				
				System.out.println("Enter customer last name");
				String lastName = sc.nextLine();
				
				System.out.println("Enter street address");
				String address = sc.nextLine();
				
				System.out.println("Enter starting account balance");
				double account_bal = sc.nextDouble();
				
				Customer cust = new Customer(firstName, lastName, address, account_bal);
				
				tDao.addNewAccount(account_bal);
				cDao.addCustomer(cust);

				
				sc.nextLine();
				
				//add log
				
				break;
			
			case "removecustomer":{
				
				System.out.println("Enter id of the customer to remove account.");
				
				int id = sc.nextInt();
				cDao.removeCustomer(id);
				sc.nextLine();
				
				//add log
				
				break;
			}
				
			case "exit":{
				printMenu = false;
				break;
			}
			
			default:
				System.out.println("Please enter a valid command");
			}
		}
		
		sc.close();
		System.out.println("Thanks for using the Bank App!");

	}
}
