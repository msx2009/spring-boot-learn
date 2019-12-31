package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	BookDao bookDao;
	
	public int addBook(Book book) {
		return bookDao.addBook(book);
	}

	public Book getBookById(Integer id) {
		return bookDao.getBookById(id);
	}
}
