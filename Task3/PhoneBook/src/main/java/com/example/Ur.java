package com.example;
import com.example.User;

public class Ur extends User {
	private String snils;
	
	public Ur(String fio, String phone, String snils) {
		super(fio, phone);
		setSnils(snils);
	}

	public void setSnils(String snils) {
		this.snils = snils;
	}

	public String getSnils() {
		return this.snils;
	}
}