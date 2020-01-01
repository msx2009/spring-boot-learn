package com.example.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.model.Book;
import com.example.demo2.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/bookOps")
	public void bookOps() {
		Book book = new Book();
		book.setName("new name by mybatis");
		book.setAuthor("new author mybatis");
		
		int i = bookService.addBook(book);
		
	}
	
	@GetMapping("/getBookById")
	public Book getBookById(Integer id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/deleteBookById")
	public int deleteBookById(Integer id) {
		return bookService.deleteBookById(id);
	}

}
