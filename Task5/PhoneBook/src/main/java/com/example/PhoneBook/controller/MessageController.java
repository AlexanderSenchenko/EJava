package com.example.PhoneBook.controller;

import com.example.PhoneBook.user.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.example.PhoneBook.PhoneBook;

import com.google.gson.Gson;

//@RestController
//@RequestMapping("users")
@Controller
public class MessageController {

	private PhoneBook phoneBook = new PhoneBook() {{
		addFiz("Fiz1", "123", "456");
		addFiz("Fiz2", "789", "012");
		addFiz("Fiz3", "345", "678");
		addUr("Ur1", "901", "234");
		addUr("Ur2", "567", "890");
		addUr("Ur3", "098", "765");
	}};

	private List<Map<String, String>> testList = new ArrayList<Map<String, String>>() {{
		add(new HashMap<String, String>() {{ put("id", "1"); put("text", "test1"); }});
		add(new HashMap<String, String>() {{ put("id", "2"); put("text", "test2"); }});
		add(new HashMap<String, String>() {{ put("id", "3"); put("text", "test3"); }});
	}};

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
	                       Map<String, Object> model) {
		model.put("name", name);
		return "greeting";
	}

	@GetMapping
	public String getFiz(Map<String, Object> model) {
		model.put("fiz", phoneBook.getListFiz());
//		model.put("soom", phoneBook.toJson(phoneBook.getListFiz()));
		return "main";
	}

	@PostMapping
	public String add(@RequestParam String fio, @RequestParam String phone,
	                  @RequestParam String phone_snils, Map<String, Object> model) {
		phoneBook.addFiz(fio, phone, phone_snils);

		model.put("fiz",  phoneBook.getListFiz());
		return "main";
	}
}
