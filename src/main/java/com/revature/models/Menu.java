package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.CustomerDao;
import com.revature.dao.TransactionsDao;

public class Menu {
	
	CustomerDao cDao = new CustomerDao();
	TransactionsDao tDao = new TransactionsDao();
	Logger log = LogManager.getLogger(Menu.class);
	
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
			System.out.println("deposit -->> make a deposit");
			System.out.println("withdrawal -->> make a withdrawal");
			System.out.println("newcustomer -->> add a new customer");
			System.out.println("removecustomer -->> remove customer by id");
			System.out.println("exit -->> leave app");
			
			//
			String command = sc.nextLine();
			
			switch(command) {
			case "customers":{
				List<Customer> customers = cDao.getCustomers();
				for(Customer cust : customers) {
					System.out.println(cust);
				}
				
				log.info("User fetched customer info.");
				
				break;
			
			}
			
			case "recenttrans": {
				List<Transaction> transactions = tDao.getTrans();
				for(Transaction tran : transactions) {
					System.out.println(tran);
				}
				
				log.info("User viewed most recent transactions.");
				
				break;
			}
			
			case "customerbyid":
				System.out.println("Which customer id would you like a record for?");
				int input = sc.nextInt();
				sc.nextLine();
				
				List <Customer> customer = cDao.getCustomerById(input);
				for(Customer cust : customer) {
					System.out.println(cust);
				}
				
				log.info("User pulled individual customer info.");
				
				break;
				
			case "deposit":{
				System.out.println("Please enter the account number.");
				int id = sc.nextInt();
				System.out.println("Enter the deposit amount.");
				double amt = sc.nextDouble();
				
				cDao.updateDeposit(amt, id);
				tDao.makeDepositByAccount(amt, id);
				
				sc.nextLine();
				
				log.info("User made deposit in account " +id);
				
				break;
			}
			
			case "withdrawal":{
				System.out.println("Please enter the account number.");
				int id = sc.nextInt();
				System.out.println("Enter amount to withdraw.");
				double amt = sc.nextDouble();
				
				cDao.updateWithdrawal(amt, id);
				tDao.makeWithdrawalByAccount(amt, id);
				
				sc.nextLine();
				
				log.info("User made withdrawal in account " +id);				
				
				break;
			}
				
			case "newcustomer":{
				
				System.out.println("Enter customer first name");
				String firstName = sc.nextLine();
				
				System.out.println("Enter customer last name");
				String lastName = sc.nextLine();
				
				System.out.println("Enter street address");
				String address = sc.nextLine();
				
				System.out.println("Enter initial deposit amount.");
				double account_bal = sc.nextDouble();
				
				Customer cust = new Customer(firstName, lastName, address, account_bal);
				
				tDao.addNewAccount(account_bal);
				cDao.addCustomer(cust);

				
				sc.nextLine();
				
				log.info("User added a new customer to the database.");
				
				break;
			}
			
		
			
			case "removecustomer":{
				
				System.out.println("Enter id of the customer to remove account.");
				
				int id = sc.nextInt();
				cDao.removeCustomer(id);
				tDao.deleteAccount(id);
				sc.nextLine();
				
				log.info("User deleted a customer from the database.");
				
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
