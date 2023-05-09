package com.masai.utility;

import java.io.Serializable;

public class IDGeneration implements Serializable{
	public static int generateId() {

		// random function generates value between 0.0000111 to 0.9999

		return (int) (Math.random() * 1000000);
	}
}
