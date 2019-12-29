package com.example.demo2;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	@PostMapping("/") //post http://localhost:8080/book/
	@CrossOrigin(value="http://localhost:8082" ,maxAge = 1800 ,allowedHeaders="*")
	public String addBook(String name) {
		return "receive:"+name;
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin(value = "http://localhost:8082" ,maxAge = 1800 ,allowedHeaders="*")
	public String deleteBookById(@PathVariable Long id) {
		return String.valueOf(id);
	}
	

}
