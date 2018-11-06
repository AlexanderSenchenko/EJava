package com.example;
import com.example.User;

public class Ur extends User {
	public Ur(String fio, String phone, String snils) {
		super(fio, phone);
		setSnils(snils);
	}

	private String snils;

	public void setSnils(String snils) {
		this.snils = snils;
	}

	public String getSnils() {
		return this.snils;
	}
}