package com.example;

import java.util.*;
import java.io.*;
import com.example.Fiz;
import com.example.Ur;

public class PhoneBook {
	private ArrayList<Fiz> fiz;
	private ArrayList<Ur> ur;

	public PhoneBook() {
		this.fiz = new ArrayList<Fiz>();
		this.ur = new ArrayList<Ur>();
	}

	public void addFiz(String fio, String phone1, String phone2) {
		Fiz fiz = new Fiz(fio, phone1, phone2);
		this.fiz.add(fiz);
	}

	public void addUr(String fio, String phone, String snils) {
		Ur ur = new Ur(fio, phone, snils);
		this.ur.add(ur);
	}

	public int getCountFiz() {
		return this.fiz.size();
	}

	public int getCountUr() {
		return this.ur.size();
	}

	private Fiz getFiz(int i) {
		return this.fiz.get(i);
	}

	private Ur getUr(int i) {
		return this.ur.get(i);
	}

	public void writeFizInFile() {
		try(FileWriter fw = new FileWriter("Fiz.csv", false)) {
			for (Fiz fiz : this.fiz) {
				String str = fiz.toCSV();
				fw.write(str);
			}
			fw.close();
		} catch(IOException error) {
			System.out.println(error.getMessage());
		}
	}

	public void writeUrInFile() {
		try(FileWriter fw = new FileWriter("Ur.csv", false)) {
			for (Ur ur : this.ur) {
				String str = ur.toCSV();
				fw.write(str);
			}
			fw.close();
		} catch(IOException error) {
			System.out.println(error.getMessage());
		}
	}

	public void readFizInFile() {
		try {
			FileInputStream fr = new FileInputStream("Fiz.csv");
			BufferedReader br = new BufferedReader(new InputStreamReader(fr));
			String str;
			
			while ((str = br.readLine()) != null) {
				System.out.println(str);
				
			}
		} catch (IOException error){
			System.out.println("Error");
		}
	}















	public void printAll() {
		printAllFiz();
		printAllUr();
	}

	public void printAllFiz() {
		System.out.println("Fiz");
		for (Fiz fiz : this.fiz) {
			System.out.print(fiz.getIndex() + "\t");
			System.out.print(fiz.getFio() + "\t");
			System.out.print(fiz.getPhone() + "\t");
			System.out.println(fiz.getPhone2());
		}
	}

	public void printAllUr() {
		System.out.println("Ur");
		for (Ur ur : this.ur) {
			System.out.print(ur.getIndex() + "\t");
			System.out.print(ur.getFio() + "\t");
			System.out.print(ur.getPhone() + "\t");
			System.out.println(ur.getSnils());
		}
	}
}