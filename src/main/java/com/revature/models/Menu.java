package com.revature.models;

import java.util.Scanner;

public class Menu {
	
	
	
	public void printMenu() {
		
		boolean printMenu = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to The Bank Management System!");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		while(printMenu) {
			System.out.println("Options Menu");
			System.out.println("Enter a command to choose an option");
			System.out.println("-----------------------------------");
			
			printMenu = false;
			
		}
	}

}
