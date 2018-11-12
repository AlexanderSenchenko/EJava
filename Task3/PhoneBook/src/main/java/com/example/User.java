package com.example;
import com.example.CSV;

public class User implements CSV {
	private static int index = 1;
	private String fio;
	private String phone;

	public User(String fio, String phone) {
		setFio(fio);
		setPhone(phone);
	}

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

	public int getIndex() {
		return this.index;
	}

	public String toCSV() {
		return String.valueOf(this.index) + ";" + this.fio + ";" + this.phone + "\n";
	}

	public void fromCSV(String str) {
		String[] arr = str.split(";");
		this.index = Integer.valueOf(arr[0]);
		this.fio = arr[1];
		this.phone = arr[2];
	}
}