package com.example;

import java.util.ArrayList;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class PhoneBook
{
	private ArrayList<Fiz> fiz;
	private ArrayList<Ur> ur;
	private ArrayList<Calls> calls;
	private ArrayList<Conference> conference;

	public PhoneBook()
	{
		this.fiz = new ArrayList<Fiz>();
		this.ur = new ArrayList<Ur>();
		this.calls = new ArrayList<Calls>();
		this.conference = new ArrayList<Conference>();
	}

	public void addFiz(String fio, String phone1, String phone2)
	{
		Fiz fiz = new Fiz(fio, phone1, phone2);
		this.fiz.add(fiz);
	}

	public void addUr(String fio, String phone, String snils)
	{
		Ur ur = new Ur(fio, phone, snils);
		this.ur.add(ur);
	}

	public int getCountFiz()
	{
		return this.fiz.size();
	}

	public int getCountUr()
	{
		return this.ur.size();
	}

	public Fiz getFiz(int i)
	{
		return this.fiz.get(i);
	}

	public Ur getUr(int i)
	{
		return this.ur.get(i);
	}

	public Fiz searchFiz(String fio)
	{
		for (Fiz fiz : this.fiz)
		{
			if (fiz.getFio() == fio)
				return fiz;
		}
		return null;
	}

	public Ur searchUr(String fio)
	{
		for (Ur ur : this.ur)
		{
			if (ur.getFio() == fio)
				return ur;
		}
		return null;
	}

	public void writeFizInFile()
	{
		try(FileWriter fw = new FileWriter("Fiz.csv", false))
		{
			for (Fiz fiz : this.fiz)
			{
				String str = fiz.toCSV();
				fw.write(str);
			}
			fw.close();
		}
		catch(IOException error)
		{
			System.out.println(error.getMessage());
		}
	}

	public void writeUrInFile()
	{
		try(FileWriter fw = new FileWriter("Ur.csv", false))
		{
			for (Ur ur : this.ur)
			{
				String str = ur.toCSV();
				fw.write(str);
			}
			fw.close();
		}
		catch(IOException error)
		{
			System.out.println(error.getMessage());
		}
	}

	public void readFizFromFile()
	{
		try
		{
			FileInputStream fr = new FileInputStream("Fiz.csv");
			BufferedReader br = new BufferedReader(new InputStreamReader(fr));
			String str;

			while ((str = br.readLine()) != null)
			{
				Fiz fiz = new Fiz();
				fiz.fromCSV(str);
				this.fiz.add(fiz);
			}
		}
		catch (IOException error)
		{
			System.out.println("Error");
		}
	}

	public void readUrFromFile()
	{
		try
		{
			FileInputStream fr = new FileInputStream("Ur.csv");
			BufferedReader br = new BufferedReader(new InputStreamReader(fr));
			String str;

			while ((str = br.readLine()) != null)
			{
				Ur ur = new Ur();
				ur.fromCSV(str);
				this.ur.add(ur);
			}
		}
		catch (IOException error)
		{
			System.out.println("Error");
		}
	}

	public void printAll()
	{
		printAllFiz();
		printAllUr();
	}

	public void printAllFiz()
	{
		System.out.println("Fiz");
		System.out.println("Ind\tFio\tPhone1\tPhone2");
		for (Fiz fiz : this.fiz)
		{
			System.out.print(fiz.getIndex() + "\t");
			System.out.print(fiz.getFio() + "\t");
			System.out.print(fiz.getPhone() + "\t");
			System.out.println(fiz.getPhone2());
		}
		System.out.println();
	}

	public void printAllUr()
	{
		System.out.println("Ur");
		System.out.println("Ind\tFio\tPhone1\tSnils");
		for (Ur ur : this.ur)
		{
			System.out.print(ur.getIndex() + "\t");
			System.out.print(ur.getFio() + "\t");
			System.out.print(ur.getPhone() + "\t");
			System.out.println(ur.getSnils());
		}
		System.out.println();
	}

	public void addCall(User user1, User user2, int sec)
	{
		Calls call = new Calls(user1.getFio(), user2.getFio(), sec);
		this.calls.add(call);
	}

	public void addCall(User user1, User user2, int min, int sec)
	{
		addCall(user1, user2, (min * 60) + sec);
	}

	public void addCall(User user1, User user2, int hours, int min, int sec)
	{
		addCall(user1, user2, (hours * 3600) + (min * 60) + sec);
	}

	public void writeCallsInFile()
	{
		try(FileWriter fw = new FileWriter("Calls.csv", false))
		{
			for (Calls call : this.calls)
			{
				String str = call.toCSV();
				fw.write(str);
			}
			fw.close();
		}
		catch(IOException error)
		{
			System.out.println(error.getMessage());
		}
	}

	public void readCallsFromFile()
	{
		try
		{
			FileInputStream fr = new FileInputStream("Calls.csv");
			BufferedReader br = new BufferedReader(new InputStreamReader(fr));
			String str;

			while ((str = br.readLine()) != null)
			{
				Calls call = new Calls();
				call.fromCSV(str);
				/*
				* Возможно что такого пользователя не будет в массивах
				* но об этом как-нибудь потом
				*/
				this.calls.add(call);
			}
		}
		catch (IOException error)
		{
			System.out.println("Error");
		}
	}

	public void printAllCalls()
	{
		System.out.println("Calls");
		System.out.println("User1\tUser2\tTime (sec.)");
		for (Calls call : this.calls)
		{
			System.out.print(call.getUser1() + "\t");
			System.out.print(call.getUser2() + "\t");
			System.out.println(call.getTime());
		}
		System.out.println();
	}

	public void addConference(ArrayList<String> users, int sec)
	{
		Conference conf = new Conference(users, sec);
		this.conference.add(conf);
	}

	public void addConference(ArrayList<String> users, int min, int sec)
	{
		addConference(users, (min * 60) + sec);
	}

	public void addConference(ArrayList<String> users,
								int hours, int min, int sec)
	{
		addConference(users, (hours * 60 * 60) + (min * 60) + sec);
	}

	public void printAllConference()
	{
		System.out.println("Conference");
		System.out.println("Users\tTime (sec.)");
		for (Conference conf : this.conference)
		{
			System.out.print(conf.toStringUsers() + "\t");
			System.out.println(conf.getTime());
		}
		System.out.println();
	}

	public void writeConferenceInFile()
	{
		try(FileWriter fw = new FileWriter("Conference.csv", false))
		{
			for (Conference conf : this.conference)
			{
				String str = conf.toCSV();
				fw.write(str);
			}
			fw.close();
		}
		catch(IOException error)
		{
			System.out.println(error.getMessage());
		}
	}

	public void readConferenceFromFile()
	{
		try
		{
			FileInputStream fr = new FileInputStream("Conference.csv");
			BufferedReader br = new BufferedReader(new InputStreamReader(fr));
			String str;

			while ((str = br.readLine()) != null)
			{
				Conference conf = new Conference();
				conf.fromCSV(str);
				/*
				* Возможно что такого пользователя не будет в массивах
				* но об этом как-нибудь потом
				*/
				this.conference.add(conf);
			}
		}
		catch (IOException error)
		{
			System.out.println("Error");
		}
	}
}