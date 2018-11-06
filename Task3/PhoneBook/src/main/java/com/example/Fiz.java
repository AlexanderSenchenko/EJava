package com.example;
import com.example.User;

public class Fiz extends User {
	public Fiz(String fio, String phone1, String phone2) {
		super(fio, phone1);
		setPhone2(phone2);
	}

	private String phone2;

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone2() {
		return this.phone2;
	}
}