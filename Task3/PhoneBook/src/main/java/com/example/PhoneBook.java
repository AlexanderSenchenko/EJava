package com.example;

import java.util.*;
import com.example.Fiz;
import com.example.Ur;

public class PhoneBook {
	public PhoneBook() {
		this.fiz = new ArrayList<Fiz>();
		this.ur = new ArrayList<Ur>();
	}

	private ArrayList<Fiz> fiz;
	private ArrayList<Ur> ur;

	public void addFiz(String fio, String phone1, String phone2) {
		Fiz fiz = new Fiz(fio, phone1, phone2);
		this.fiz.add(fiz);
	}

	public void addUr(String fio, String phone, String snils) {
		Ur ur = new Ur(fio, phone, snils);
		this.ur.add(ur);
	}

	public Integer getCountFiz() {
		return this.fiz.size();
	}

	public Integer getCountUr() {
		return this.ur.size();
	}

	public Fiz getFiz(Integer i) {
		return this.fiz.get(i);
	}

	public Ur getUr(Integer i) {
		return this.ur.get(i);
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