package com.example.PhoneBook.calls;

import java.util.ArrayList;

import com.example.PhoneBook.csv.CSV;

public class Conference implements CSV {
	private ArrayList<String> users;
	private int sec;

	public Conference(ArrayList<String> users, int sec) {
		this.users = users;
		this.sec = sec;
	}

	public Conference() {}

	public ArrayList<String> getUsers() {
		return this.users;
	}

	public int getTime() {
		return this.sec;
	}

	public String toStringUsers() {
		StringBuilder users = new StringBuilder();
		for (String user : this.users) {
			users.append(user);
			users.append(" ");
		}
		return users.toString();
	}

	public String toCSV() {
		return toStringUsers() + ";" + String.valueOf(this.sec) + "\n";
	}

	public void fromCSV(String str) {
		String[] arr = str.split(";");
		String[] users = arr[0].split(" ");
		
		this.users = new ArrayList<String>();
		for (String user : users) {
			this.users.add(user);
		}
		this.sec = Integer.valueOf(arr[1]);
	}
}