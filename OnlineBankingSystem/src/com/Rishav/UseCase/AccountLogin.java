package com.Rishav.UseCase;

import java.util.Scanner;

import com.Rishav.Custom.ConsoleColors;
import com.Rishav.Dao.AccountantDao;
import com.Rishav.Dao.AccountantDaoImpl;
import com.Rishav.Exceptions.AccountantException;
import com.Rishav.Model.Accountant;

public class AccountLogin {
 
	public static Accountant AccountantLogin() throws AccountantException{
		
		boolean flag = false;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.ORANGE + "Enter Username" + ConsoleColors.RESET);
		String email = sc.next();
		
		System.out.println(ConsoleColors.ORANGE + "Enter Password" + ConsoleColors.RESET);
		int password = sc.nextInt();
		
		AccountantDao dao = new AccountantDaoImpl();
		
		try {
			accountant = dao.AccountantLogin(email,password);
		}
		
		
		return accountant;
		
		
		
	}

}
//public static Customer CusLogin() {
//	
//	Customer customer = null;
//	
//	try {
//		
//		Scanner sc = new Scanner (System.in);
//		
//		System.out.println(ConsoleColors.ORANGE + "Enter Username" + ConsoleColors.RESET);
//		String username = sc.next();
//		
//		System.out.println(ConsoleColors.ORANGE + "Enter Password" + ConsoleColors.RESET);
//		String password = sc.next();
//		
//		CustomerDao dao = new CustomerDaoImpl();
//		
//		try {
//			customer = dao.cusLogin(username, password);
//			
//			System.out.println(ConsoleColors.ROSY_PINK + "Welcome " + customer.getFirstName() + " " + customer.getLastName() + ConsoleColors.RESET);
//		} catch (CustomerException e) {
//			
//			System.out.println(ConsoleColors.RED_BACKGROUND + e.getMessage() + ConsoleColors.RESET);
//		}
//	}
//	catch (InputMismatchException e) {
//		System.out.println(ConsoleColors.RED_BACKGROUND + e.getMessage() + ConsoleColors.RESET);
//	}
//	
//	return customer;
//
//}
//}
