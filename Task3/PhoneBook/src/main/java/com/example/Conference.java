package com.example;

import java.util.ArrayList;

public class Conference
{
	private ArrayList<User> users;
	private int sec;

	public Conference(ArrayList<User> users, int sec)
	{
		this.users = users;
		this.sec = sec;
	}
}