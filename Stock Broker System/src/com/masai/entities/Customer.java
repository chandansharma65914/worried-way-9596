package com.masai.entities;
import java.util.*;
import java.io.Serializable;
public class Customer implements Serializable{
	private String firstName;
	private String lastName;	
	private String email;
	private String mobileNumber;
	private String password;
	private String address;
	private int walletBalance=0;
	private Map<String,Integer> stock= new HashMap<>();
	private List<String> transaction= new ArrayList<>();
	public Customer(String firstName, String lastName, String email, String mobileNumber, String password,
			String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.address = address;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(int walletBalance) {
		this.walletBalance = walletBalance;
	}
	public Map<String, Integer> getStock() {
		return stock;
	}
	public void setStock(Map<String, Integer> stock) {
		this.stock = stock;
	}
	public List<String> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<String> transaction) {
		this.transaction = transaction;
	}
	@Override
	public String toString() {
		return "Customer [Full Name = " + firstName +" "+ lastName+ "email=" + email + ", mobileNumber="
				+ mobileNumber + ", password=" + password + ", address=" + address + ", walletBalance=" + walletBalance
				+ ", Number of stock=" + stock.size() + "]";
	}
	
}
