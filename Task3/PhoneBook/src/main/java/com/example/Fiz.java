package com.example;

public class Fiz extends User
{
	private static int index = 1;
	private String phone2;

	public Fiz(String fio, String phone1, String phone2)
	{
		super(fio, phone1);
		setPhone2(phone2);
		setId(index++);
	}

	public Fiz() {}

	public void setPhone2(String phone2)
	{
		this.phone2 = phone2;
	}

	public String getPhone2()
	{
		return this.phone2;
	}

	public String toCSV()
	{
		String str = super.toCSV();
		return str + this.phone2 + "\n";
	}

	public void fromCSV(String str)
	{
		super.fromCSV(str);
		String[] arr = str.split(";");
		this.phone2 = arr[3];
	}

	public String addFizToBD()
	{
		// "INSERT INTO fiz VALUES ('3', 'test1', '123', '456');"
//		String insert = "INSERT INTO fiz VALUES ('3', 'test1', '123', '456');";
//		insert += Integer.toString();

		String insert = super.addUserToDB();
		insert += this.phone2 += "');";

		return insert;
	}
}