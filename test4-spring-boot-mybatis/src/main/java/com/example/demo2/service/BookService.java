package com.example.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.mapper.BookMapper;

import com.example.demo2.model.Book;

@Service
public class BookService {
	@Autowired
	BookMapper bookMapper;
	
	
	public int addBook(Book book) {
		return bookMapper.addBook(book);
	}
	
	public Book getBookById(Integer id) {
		return bookMapper.getBookById(id);
	}
}
