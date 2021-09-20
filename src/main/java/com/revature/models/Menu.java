package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.CustomerDao;

public class Menu {
	
	CustomerDao cDao = new CustomerDao();
	
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
