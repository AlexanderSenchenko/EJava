package com.example;
import com.example.User;

public class Ur extends User {
	private static int index = 1;
	private String snils;
	
	public Ur() {

	}

	public void initUr(String fio, String phone, String snils) {
		initUser(fio, phone);
		setSnils(snils);
		setId(index++);
	}

	public void setSnils(String snils) {
		this.snils = snils;
	}

	public String getSnils() {
		return this.snils;
	}

	public String toCSV() {
		String str = super.toCSV();
		return str + this.snils + "\n";
	}

	public void fromCSV(String str) {
		super.fromCSV(str);
		String[] arr = str.split(";");
		this.snils = arr[3];
	}
}