package com.example;

import java.util.*;
import java.io.*;
import com.example.PhoneBook;
// import com.example.User;

public class Main {

	public static void main(String[] args) {	
		PhoneBook phonebook = new PhoneBook();

		phonebook.addFiz("Sandra", "123", "456");
		phonebook.addFiz("Roflan", "789", "012");
		phonebook.addFiz("Chelick", "234", "567");

		phonebook.addUr("Sandra", "789", "567");
		phonebook.addUr("Roflan", "789", "012");
		phonebook.addUr("Chelick", "012", "789");

		// try (FileReader fr = new FileReader("Fiz.csv")) {
		// 	char[] buf = new char[256];
		// 	String str = "";
		// 	ArrayList<String> strings = new ArrayList<String>();
		// 	int line = fr.read(buf);

		// 	for (int i = 0; i < line && buf[i] != '\n'; i++) {
		// 		str += buf[i];
		// 	}
		// 	strings.add(str);

		// 	System.out.println("Line: " + line);
		// 	System.out.println("String: " + str);
		// 	// System.out.print("String: ");
		// 	// for (char a : buf) {
		// 	// 	System.out.print(a);
		// 	// }
		// 	fr.close();
		// } catch (IOException error) {
		// 	System.out.println(error.getMessage());
		// }

		// phonebook.printAll();

		phonebook.writeFizInFile();

		phonebook.writeUrInFile();

		phonebook.readFizInFile();
	}

	static void testTime() {
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
}