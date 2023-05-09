package com.masai;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.masai.entities.Customer;
import com.masai.entities.Stock;
import com.masai.entities.Transaction;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.NoStockAvailable;
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
			afterAdminLogin();
		} else {
			throw new InvalidDetailsException("Invalid Admin Credentials");
		}
	}
	//***************************************************************************************************************************//
	
	
    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
    	Map<String, Customer> customers =  FileExists.customerFile();
    	try {
    		System.out.println("<-----------------------------Welcome , in Product Management System---------------------------------->");
    	    System.out.println("<----------------------------------------------------------------------------------------------------->");
    		boolean flag=true;
 			do {
    		try {
                
		
    				System.out.println("Enter 1 for Admin login");
    				System.out.println("Enter 2 for Customer login");
    				System.out.println("Enter 3 for Customer Signup");
    				System.out.println("Enter 0 for Exist");
    				int preference = sc.nextInt();
    				switch (preference) {
    				case 1:
    					adminLogin(sc);
    					break;
    				case 2:
    					customerLogin(sc);
    					break;

    				case 3:
    					customerSignup();
    					break;

    				case 0:
    					System.out.println("successfully existed from the system");
                                flag=false;
    					break;

    				default:
    					throw new IllegalArgumentException("Invalid Selection");
    				}

    			

    		

    		} catch (Exception e) {

    			System.out.println(e.getMessage());
    		}
    		}while(flag);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
	}
    
    
    
    
    public static void afterAdminLogin() {
    	boolean flag=true;
    	do {
    	try {

			Scanner sc= new Scanner(System.in);
			
			
			System.out.println("<------------------------------------------------>");
			System.out.println("Enter 1 for see all customers");
			System.out.println("Enter 2 for Add new Stocks");
			System.out.println("Enter 3 for View all Stocks");
			System.out.println("Enter 4 for View Sold Stocks");
			System.out.println("Enter 5 for View unsold Stocks");
			System.out.println("Enter 6 for Delete Stocks");
			System.out.println("Enter 0 for Exist");
			int preference = sc.nextInt();
			sc.nextLine();
			switch (preference) {
			case 1:
				viewCustomers();
				break;
			case 2:
				addStock();
				break;

			case 3:
				viewNotSoldStock();viewAllSoldStock();
				break;
			case 4:
				viewAllSoldStock();
				break;

			case 5:
				viewNotSoldStock();
				break;
			case 6:
				deleteStock();
				break;
			case 0:
				System.out.println("successfully existed from the system");
                        flag=false;
				break;

			default:
				throw new IllegalArgumentException("Invalid Selection");
			}

		

	

	} catch (Exception e) {

		System.out.println(e.getMessage());
	}
    	}while(flag);
    }
  //***************************************************************************************************************************//
	   
    
    
    public static void afterCustomerLogin(String email) {
    	boolean flag=true;
    	do {
    	try {

			Scanner sc= new Scanner(System.in);
			
			System.out.println();
			System.out.println();
			System.out.println("Enter 1 for see my own stock");
			System.out.println("Enter 2 for buy stock");
			System.out.println("Enter 3 for sell stocks");
			System.out.println("Enter 4 to see my transaction");
			System.out.println("Enter 5 to add money to wallet");
			System.out.println("Enter 6 to withraw money from wallet");
			System.out.println("Enter 0 for Exist");
			int preference = sc.nextInt();
			sc.nextLine();
			switch (preference) {
			case 1:
				viewMyStock( email);
				break;
			case 2:
				buyStock( email);
				break;

			case 3:
				sellStock( email);
				break;
			case 4:
				viewCustomerOwnTransaction( email);
				break;

			case 5:
				addMoney( email);
				break;
			case 6:
				withrawMoney( email);
				break;
			case 0:
				System.out.println("successfully existed from the system");
                        flag=false;
				break;

			default:
				throw new IllegalArgumentException("Invalid Selection");
			}

		

	

	} catch (Exception e) {

		System.out.println(e.getMessage());
	}
    	}while(flag);
    }
    public static void customerLogin(Scanner sc)throws InvalidDetailsException {
    	System.out.println("please enter the following details to login");
		System.out.println("please enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		Map<String, Customer> customers =  FileExists.customerFile();
		if(customers.containsKey(email)) {
			Customer custom= customers.get(email);
			if(custom.getPassword().equals(pass)) {
				System.out.println("Login Success");
				afterCustomerLogin( email);
			}
		}else {
			throw new InvalidDetailsException("please put right email");
		}
    }
  //***************************************************************************************************************************//
	
    public static void customerSignup() throws FileNotFoundException, IOException {
    	Scanner sc= new Scanner(System.in);
    	Map<String, Customer> customers =  FileExists.customerFile();
    	System.out.println("Enter your first name");
    	String firstName=sc.next();
    	System.out.println("Enter your Last name");
    	String lastName=sc.next();
    	System.out.println("Enter your email ");
    	String email=sc.next();
    	System.out.println("Enter your mobile number");
    	String mobile=sc.next();
    	
    	System.out.println("Enter your address ");
    	String address=sc.next();
    	System.out.println("Enter your password ");
    	String password=sc.next();
    	System.out.println("Enter wallet balance");
    	int walletBalance= sc.nextInt();
    	
    	Customer newCustomer= new Customer(firstName,lastName,email,mobile,address,password,walletBalance);
    	if(customers!=null) {
    	customers.put(email, newCustomer);
    	}else {
    		customers= new HashMap<String,Customer>();
    		customers.put(email, newCustomer);
    	}
    	File f = new File("Customer.ser");
    	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(customers);
		System.out.println("Signup Success");
    }
  //***************************************************************************************************************************//
	
    
        public static void withrawMoney(String email) throws FileNotFoundException, IOException {
        	System.out.println("Enter the amount you want to withraw from your wallet");
        	Scanner sc=new Scanner(System.in);
        	int amount=sc.nextInt();
        			
        	Map<String, Customer> customers =  FileExists.customerFile();
        	Customer custom=customers.get(email);
        	custom.setWalletBalance(custom.getWalletBalance()-amount);
        	customers.put(email, custom);
        	File f = new File("Customer.ser");
        	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
    		oos.writeObject(customers);
        }
      //***************************************************************************************************************************//
    	    
        
        public static void addMoney(String email) throws FileNotFoundException, IOException {
        	System.out.println("Enter the amount you want to add to your wallet");
        	Scanner sc=new Scanner(System.in);
        	int amount=sc.nextInt();
        			
        	Map<String, Customer> customers =  FileExists.customerFile();
        	Customer custom=customers.get(email);
        	custom.setWalletBalance(custom.getWalletBalance()+amount);
        	
        	customers.put(email, custom);
        	File f = new File("Customer.ser");
        	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
    		oos.writeObject(customers);
        }
        
      //***************************************************************************************************************************//
    	
        public static void viewCustomers() {
        	Map<String, Customer> customers =  FileExists.customerFile();
        	Set<String> keys= customers.keySet();
        	for(String key:keys) {
        		System.out.println(customers.get(key));
        	}
        }
        
      //***************************************************************************************************************************//
    	
        public static void buyStock(String email) {
        	Map<String, List<Stock>> sFile = FileExists.stockFile();
        	
        }
        
      //***************************************************************************************************************************//
    	
        public static void sellStock(String email) {
        	
        }
      //***************************************************************************************************************************//
    	
        
        public static void viewMyStock(String email) throws Exception {
        	Map<String, List<Stock>> sFile = FileExists.stockFile();
        	if(sFile.containsKey(email)) {
        		List<Stock> list= sFile.get(email);
        		if(list!=null) {
        		for(Stock s:list) {
        			System.out.println(s);
        		}
        		}else {
        			throw new NoStockAvailable("There no stock Available");
        		}
        	}
        }
        //********************************************************************************************************************//
        
        public static void  viewNotSoldStock() throws Exception {
        	System.out.println("All stock are");
        	Map<String, List<Stock>> sFile = FileExists.stockFile();
        	if(sFile.containsKey("admin")) {
        		List<Stock> list= sFile.get("admin");
        		if(list!=null) {
        		for(Stock s:list) {
        			System.out.println(s);
        		}
        		}else {
        			throw new NoStockAvailable("There no stock Available");
        		}
        	}
        }
        //********************************************************************************************************************//
        
        public static void  viewAllSoldStock() throws NoStockAvailable {
        	Map<String, List<Stock>> sFile = FileExists.stockFile();
        	Set<String> keys=sFile.keySet();
        	boolean flag=true;
        	for(String key:keys) {
        		if(!key.equals("admin") ){
        			List<Stock> list= sFile.get(key);
        			if(list!=null) {
        				for(Stock s:list) {
        					System.out.println(s); 
        					flag=false;
        				}
        			}
        		}
        	}
        	if(flag) {
        		System.out.println("No any sold stock");
        	}
        }
        
        //************************************************************************************************************************//
        
        public static void addStock() throws FileNotFoundException, IOException {
        	Map<String, List<Stock>> sFile = FileExists.stockFile();
        	Scanner sc= new Scanner(System.in);
        	System.out.println("Please enter the amount of stock");
        	int price= sc.nextInt();
        	if(sFile==null) {
        		sFile= new HashMap<String,List<Stock>>();
        		List<Stock> list= new ArrayList<>();
        		list.add(new Stock(price));
        		sFile.put("admin", list);
        	}else {
        		List<Stock> list= sFile.get("admin");
        		if(list==null) {
        			 list= new ArrayList<Stock>();
        		}
        		list.add(new Stock(price));
        		sFile.put("admin", list);
        	}
        	File f = new File("Stock.ser");
        	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(sFile);
        }
        //*************************************************************************************************************************//
        
        public static void deleteStock() throws FileNotFoundException, IOException {
        	Scanner sc= new Scanner(System.in);
        	
        	System.out.println("Enter stock id you want to delete");
        	int id= sc.nextInt();
        	Map<String, List<Stock>> pFile = FileExists.stockFile();
        	Set<String> keys=pFile.keySet();
                  for(String key:keys) {
                	  List<Stock> list= pFile.get(key);
                      for(int i=0;i<list.size();i++) {
                    	  Stock s=list.get(i);
                    	  if(s.getId()==id) {
                    		  list.remove(i);
                    	  }
                    	  
                      }pFile.put(key, list);
                      System.out.println("Stock deleted successfully");
                      break;
                  }
                  
    		File f = new File("Stock.ser");
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(pFile);
			
        }
        
      //***************************************************************************************************************************//
    	public static void viewCustomerOwnTransaction(String email) {
    		List<Transaction> tFile = FileExists.transactionFile();
    		for(Transaction t: tFile) {
    			if(t.getEmail().equals(email)) {
    				System.out.println(t);
    			}
    		}
    	}
    	//***************************************************************************************************************************//
    	
    	public static void viewAllTransactionAdmin() {
    		List<Transaction> tFile = FileExists.transactionFile();
    		for(Transaction t: tFile) {   			
    				System.out.println(t);   			
    		}
    	}
    	
    	
}
