package com.example;
import com.example.CSV;

public class User implements CSV
{
	private String fio;
	private String phone;
	private int id;

	public User(String fio, String phone)
	{
		setFio(fio);
		setPhone(phone);
	}

	public User() {}

	// public void initUser(String fio, String phone)
	// {
	// 	setFio(fio);
	// 	setPhone(phone);
	// }

	public void setId(int index)
	{
		this.id = index;
	}

	public void setFio(String fio)
	{
		this.fio = fio;
	}

	public String getFio()
	{
		return this.fio;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public int getIndex()
	{
		return this.id;
	}

	public String toCSV()
	{
		return String.valueOf(this.id) + ";" + this.fio + ";" + this.phone + ";";
	}

	public void fromCSV(String str)
	{
		String[] arr = str.split(";");
		this.id = Integer.valueOf(arr[0]);
		this.fio = arr[1];
		this.phone = arr[2];
	}
}