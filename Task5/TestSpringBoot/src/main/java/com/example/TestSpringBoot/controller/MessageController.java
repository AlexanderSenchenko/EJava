package com.example.TestSpringBoot.controller;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import java.time.LocalDateTime;

import com.example.TestSpringBoot.domain.Message;
//import com.example.TestSpringBoot.exceptions.NotFoundException;
import com.example.TestSpringBoot.repo.MessageRepo;

@RestController // wtf? RestController and Controller
@RequestMapping("message")
public class MessageController {
	/* До подкючения DB */
//	private int counter = 4;
//	private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
//		add(new HashMap<String, String>() {{ put("id", "1"); put("text", "First message"); }});
//		add(new HashMap<String, String>() {{ put("id", "2"); put("text", "Second message"); }});
//		add(new HashMap<String, String>() {{ put("id", "3"); put("text", "Third message"); }});
//	}};

	private final MessageRepo messageRepo;

	@Autowired
	public MessageController(MessageRepo messageRepo) {
		this.messageRepo = messageRepo;
	}

//	@GetMapping
//	public List<Map<String, String>> list() {
//		return messages;
//	}
	@GetMapping
	public List<Message> list() {
		return messageRepo.findAll();
	}

//	@GetMapping("{id}")
//	public Map<String, String> getOne(@PathVariable String id) {
//		return getMessage(id);
//	}
	@GetMapping("{id}")
	public Message getOne(@PathVariable("id") Message message) {
		return message;
	}

//	private Map<String, String> getMessage(@PathVariable String id) {
//		return messages.stream()
//				.filter(messages -> messages.get("id").equals(id))
//				.findFirst()
//				.orElseThrow(NotFoundException::new);
//	}

//	@PostMapping
//	public Map<String, String> create(@RequestBody Map<String, String> message) {
//		message.put("id", String.valueOf(counter++));
//
//		messages.add(message);
//
//		return message;
//	}
	@PostMapping
	public Message create(@RequestBody Message message) {
		message.setCreationDate(LocalDateTime.now());
		return messageRepo.save(message);
	}

//	@PutMapping("{id}")
//	public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
//		Map<String, String> messageFromDb = getMessage(id);
//
//		messageFromDb.putAll(message);
//		messageFromDb.put("id", id);
//
//		return messageFromDb;
//	}
	@PutMapping("{id}")
	public Message update(@PathVariable("id") Message messageFromDb, @RequestBody Message message ) {
		BeanUtils.copyProperties(message, messageFromDb, "id");

		return messageRepo.save(messageFromDb);
	}

//	@DeleteMapping("{id}")
//	public void delete(@PathVariable String id) {
//		Map<String, String> message = getMessage(id);
//
//		messages.remove(message);
//	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Message message) {
		messageRepo.delete(message);
	}
}