package com.masai.entities;

import java.io.Serializable;

import com.masai.utility.IDGeneration;

public class Stock implements Serializable{
       private int id;
       private int price;
	    public Stock(int price) {
		super();
		this.id = IDGeneration.generateId();
		this.price = price;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
		
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", price=" + price + "]";
	}
	
}
