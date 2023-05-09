package com.masai.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable{
     private String email;
     private String name;
     private Stock stock;
     private int price;
     private LocalDate dt;
     private String type;
	public Transaction(String email, String name, Stock stock, int price, LocalDate dt,String type) {
		
		this.email = email;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.dt = dt;
		this.type=type;
	}
	public Transaction() {
		
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getDt() {
		return dt;
	}
	public void setDt(LocalDate dt) {
		this.dt = dt;
	}
	@Override
	public String toString() {
		return "Transaction [email=" + email + ", name=" + name + ", stock=" + stock.toString() + ", price=" + price + ", dt=" + dt
				+ "]";
	}
	
	
}
