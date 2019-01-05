package com.example;

import java.util.*;
import java.io.*;
import java.sql.*;
import com.example.PhoneBook;

public class Main
{
	public static void main(String[] args)
	{
		testAddUser();
		
		// testMySQL();
		
	}

	static void testTime()
	{
		LinkedList<String> list = new LinkedList<String>();
		ArrayList<String> arr = new ArrayList<String>();
		TreeSet<String> tree = new TreeSet<String>();

		System.out.println("Add");

		long t_list_add = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list.add(String.valueOf(i));
		}
		t_list_add = System.nanoTime() - t_list_add;
		
		long t_arr_add = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			arr.add(String.valueOf(i));
		}
		t_arr_add = System.nanoTime() - t_arr_add;

		long t_tree_add = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			tree.add(String.valueOf(i));
		}
		t_tree_add = System.nanoTime() - t_tree_add;

		System.out.println("t(list add) = " + t_list_add);
		System.out.println("t(arr  add) = " + t_arr_add);
		System.out.println("t(tree add) = " + t_tree_add);

		System.out.println("Remove");

		long t_list_remove = System.nanoTime();
		list.remove(String.valueOf(500));
		t_list_remove = System.nanoTime() - t_list_remove;
		
		long t_arr_remove = System.nanoTime();
		arr.remove(String.valueOf(500));
		t_arr_remove = System.nanoTime() - t_arr_remove;

		long t_tree_remove = System.nanoTime();
		tree.remove(String.valueOf(500));
		t_tree_remove = System.nanoTime() - t_tree_remove;

		System.out.println("t(list remove) = " + t_list_remove);
		System.out.println("t(arr  remove) = " + t_arr_remove);
		System.out.println("t(tree remove) = " + t_tree_remove);
	}

	static void testAddUser()
	{
		PhoneBook phonebook = new PhoneBook();
		PhoneBook phonebook2 = new PhoneBook();

		phonebook.addFiz("Sandra", "123", "456");
		phonebook.addFiz("Roflan", "789", "012");
		phonebook.addFiz("Chelick", "234", "567");
		phonebook.addFiz("Misha", "1", "1");

		phonebook.addUr("Sandra", "789", "567");
		phonebook.addUr("Roflan", "789", "012");
		phonebook.addUr("Chelick", "012", "789");

		phonebook.printAll();

		phonebook.writeFizInFile();

		phonebook.writeUrInFile();

		phonebook2.readFizFromFile();
		phonebook2.readUrFromFile();

		phonebook2.printAll();
	}

	static void testMySQL()
	{
		String user = "root";
		String password = "65roguri";
		String url = "jdbc:mysql://localhost:3306/eltex";

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			
			String query = "SELECT * FROM user";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String fio = rs.getString("fio");
				System.out.println(fio);
			}
			System.out.println("Success");
		} catch(SQLException error) {
			error.printStackTrace();
		}
	}
}