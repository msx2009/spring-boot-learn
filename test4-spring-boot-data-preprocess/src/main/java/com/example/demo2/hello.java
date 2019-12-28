package com.example.demo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class hello {

	@GetMapping("/hello")
	public String book(@ModelAttribute("a") Book book,@ModelAttribute("b") Author author) {
		return book.getName()+"..."+author.getName();
		
	}

}
