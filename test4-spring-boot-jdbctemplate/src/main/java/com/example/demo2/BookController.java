package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/bookOps")
	public void bookOps() {
		Book book = new Book();
		book.setName("new name");
		book.setAuthor("new author");
		
		int i = bookService.addBook(book);
		
	}
	
	@GetMapping("/getBookById")
	public Book getBookById(Integer id) {
		return bookService.getBookById(id);
	}

}
