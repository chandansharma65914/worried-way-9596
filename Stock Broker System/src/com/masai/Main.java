package com.masai;

import java.util.Map;
import java.util.Scanner;

import com.masai.entities.Customer;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.utility.Admin;
import com.masai.utility.FileExists;

public class Main {
	
	public static void adminLogin(Scanner sc) throws InvalidDetailsException {

		System.out.println("Enter the user name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		if (userName.equals(Admin.username) && password.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvalidDetailsException("Invalid Admin Credentials");
		}
	}
    public static void main(String[] args) {
    	Map<Integer, Customer> customers = FileExists.customerFile();
    	
	}
}
