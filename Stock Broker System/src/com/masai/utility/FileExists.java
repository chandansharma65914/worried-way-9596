package com.masai.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.masai.entities.Customer;

import com.masai.entities.Stock;
import com.masai.entities.Transaction;

public class FileExists {

	public static Map<Integer, Customer> customerFile() {

		Map<Integer, Customer> cFile = null;

		File f = new File("Customer.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			

			if (flag) {

				cFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(cFile);
				return cFile;

			} else {

				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				cFile = (Map<Integer, Customer>) ois.readObject();

				return cFile;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return cFile;
	}
}
