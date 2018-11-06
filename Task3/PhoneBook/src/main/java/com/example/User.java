package com.example;

public class User {
	public User(String fio, String phone) {
		setFio(fio);
		setPhone(phone);
	}

	static Integer index = 1;
	private String fio;
	private String phone;

	public void setFio(String fio) {
		this.fio = fio;
	}

	public String getFio() {
		return this.fio;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public Integer getIndex() {
		return this.index;
	}
}