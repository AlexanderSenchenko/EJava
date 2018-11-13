package com.example;
import com.example.User;

public class Ur extends User {
	private static int index = 1;
	private String snils;
	
	public Ur(String fio, String phone, String snils) {
		super(fio, phone);
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
}