package com.example;

public class Ur extends User
{
	private static int index = 1;
	private String snils;
	
	public Ur(String fio, String phone, String snils)
	{
		super(fio, phone);
		setSnils(snils);
		setId(index++);
	}

	public Ur() {}

	public void setSnils(String snils)
	{
		this.snils = snils;
	}

	public String getSnils()
	{
		return this.snils;
	}

	public String toCSV()
	{
		String str = super.toCSV();
		return str + this.snils + "\n";
	}

	public void fromCSV(String str)
	{
		super.fromCSV(str);
		String[] arr = str.split(";");
		this.snils = arr[3];
	}
}