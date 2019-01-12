package com.example;

public class Calls implements CSV
{
	private String user1;
	private String user2;
	private int sec;

	public Calls(String user1, String user2, int sec)
	{
		this.user1 = user1;
		this.user2 = user2;
		this.sec = sec;
	}

	public Calls() {}

	public String getUser1()
	{
		return this.user1;
	}

	public String getUser2()
	{
		return this.user2;
	}

	public int getTime()
	{
		return this.sec;
	}

	public String toCSV()
	{
		return this.user1 + ";"
				+ this.user2 + ";"
				+ String.valueOf(this.sec) + "\n";
	}

	public void fromCSV(String str)
	{
		String[] arr = str.split(";");
		this.user1 = arr[0];
		this.user2 = arr[1];
		this.sec = Integer.valueOf(arr[2]);
	}
}