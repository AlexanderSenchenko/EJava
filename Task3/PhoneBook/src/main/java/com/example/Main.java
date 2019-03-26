package com.example;

//import java.util.*;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.TreeSet;

//import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main
{
	public static void main(String[] args)
	{
		// testAddUser();
		
		testMySQL();
		
		// testCalls();

		// testConference();
	}

	public static void testTime()
	{
		LinkedList<String> list = new LinkedList<String>();
		ArrayList<String> arr = new ArrayList<String>();
		TreeSet<String> tree = new TreeSet<String>();

		System.out.println("Add");

		long t_list_add = System.nanoTime();
		for (int i = 0; i < 1000; i++)
		{
			list.add(String.valueOf(i));
		}
		t_list_add = System.nanoTime() - t_list_add;
		
		long t_arr_add = System.nanoTime();
		for (int i = 0; i < 1000; i++)
		{
			arr.add(String.valueOf(i));
		}
		t_arr_add = System.nanoTime() - t_arr_add;

		long t_tree_add = System.nanoTime();
		for (int i = 0; i < 1000; i++)
		{
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

	public static void testAddUser()
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

	public static void testMySQL()
	{
		PhoneBook phoneBook = new PhoneBook();

		Fiz fiz = new Fiz("Sandra", "123", "456");

		String user = "root";
		String password = "65roguri";
		String url = "jdbc:mysql://localhost:3306/phone_book";

		// System.out.print("Input password: ");
		// Scanner in = new Scanner(System.in);
		// password = in.next();
		// in.close();

		try
		{
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			/**
			*	SHOW DATABASES;
			*	CREATE DATABASE "name DB";
			*	USE "name database";
			*	SELECT DATABASE(); - текущая база
			*	
			*	SHOW TABLES;
			*	CREATE TABLE "name" ("name column" тип, "name column" тип, ...);
			*	DESCRIBE "name tables";
			*	
			*	INSERT INTO "name" VALUES ('column1', 'column2', ...);
			*	INSERT INTO "name" VALUE ();
			*	
			*	SELECT "what or '*'" FROM "tables name";
			*	SELECT "what or '*'" FROM "tables name" WHERE;
			*	
			*	DELETE FROM "table name" WHERE "column"="value";
			*	
			*	UPDATE "name table" SET "column"="value", ... ;
			*	UPDATE "name table" SET "column"="value" WHERE "id=3";
			**/

			String query = "SELECT * FROM fiz";
			ResultSet rs = st.executeQuery(query);
			System.out.println("Table: fiz");
			while (rs.next())
			{
				String fio = rs.getString("fio");
				System.out.println(fio);
			}
			System.out.println();

			System.out.println("Insert");			
			String insert = fiz.addFizToBD();
			st.execute(insert);

			rs = st.executeQuery(query);
			System.out.println("Table: fiz");
			while (rs.next())
			{
				String fio = rs.getString("fio");
				System.out.println(fio);
			}
			System.out.println();

			System.out.println("Delete");
			String delete = "DELETE FROM fiz WHERE id=3;";
			st.execute(delete);

			rs = st.executeQuery(query);
			System.out.println("Table: fiz");
			while (rs.next())
			{
				String fio = rs.getString("fio");
				System.out.println(fio);
			}
			System.out.println();

			String query2 = query + " WHERE id>0";
			rs = st.executeQuery(query2);
			while (rs.next())
			{
				String id = rs.getString("id");
				System.out.println(id);
			}
			System.out.println();

			// System.out.println("Update");
			// String update = "UPDATE fiz SET fio='test2' WHERE id=1;";
			// st.execute(update);

			// rs = st.executeQuery(query);
			// System.out.println("Table: fiz");
			// while (rs.next())
			// {
			// 	String fio = rs.getString("fio");
			// 	System.out.println(fio);
			// }
			// System.out.println();

		}
		catch(SQLException error)
		{
			error.printStackTrace();
		}
	}

	public static void testCalls()
	{
		PhoneBook phonebook = new PhoneBook();
		PhoneBook phonebook2 = new PhoneBook();

		phonebook.addFiz("a", "00", "00");
		phonebook.addFiz("b", "01", "01");
		phonebook.addFiz("c", "02", "02");
		phonebook.addFiz("d", "03", "03");

		phonebook.addUr("e", "04", "04");
		phonebook.addUr("f", "05", "05");
		phonebook.addUr("g", "06", "06");

		phonebook.printAll();

		phonebook.writeFizInFile();

		phonebook.writeUrInFile();

		phonebook.addCall(phonebook.getFiz(0), phonebook.getUr(1), 10);
		phonebook.addCall(phonebook.getFiz(2), phonebook.getFiz(3), 10);
		phonebook.addCall(phonebook.getFiz(2), phonebook.getFiz(1), 1, 30);
		phonebook.addCall(phonebook.getFiz(0), phonebook.getFiz(3), 1, 1, 30);

		phonebook.printAllCalls();

		phonebook.writeCallsInFile();

		phonebook2.readCallsFromFile();

		phonebook.printAllCalls();
	}

	public static void testConference()
	{
		PhoneBook phonebook = new PhoneBook();
		PhoneBook phonebook2 = new PhoneBook();

		phonebook.addFiz("a", "00", "00");
		phonebook.addFiz("b", "01", "01");
		phonebook.addFiz("c", "02", "02");
		phonebook.addFiz("d", "03", "03");

		phonebook.addUr("e", "04", "04");
		phonebook.addUr("f", "05", "05");
		phonebook.addUr("g", "06", "06");
		phonebook.addUr("k", "07", "07");

		phonebook.printAll();

		phonebook.writeFizInFile();

		phonebook.writeUrInFile();

		ArrayList<String> conf1 = new ArrayList<String>();
		conf1.add(phonebook.getFiz(0).getFio());
		conf1.add(phonebook.getFiz(1).getFio());
		conf1.add(phonebook.getFiz(2).getFio());
		phonebook.addConference(conf1, 10);

		ArrayList<String> conf2 = new ArrayList<String>();
		conf2.add(phonebook.getUr(0).getFio());
		conf2.add(phonebook.getFiz(3).getFio());
		conf2.add(phonebook.getUr(2).getFio());
		phonebook.addConference(conf2, 2, 10);

		phonebook.printAllConference();

		phonebook.writeConferenceInFile();

		phonebook2.readConferenceFromFile();
	
		phonebook2.printAllConference();
	}
}
