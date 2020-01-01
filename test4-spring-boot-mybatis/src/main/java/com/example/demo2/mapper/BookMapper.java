package com.example.demo2.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo2.model.Book;

@Mapper
public interface BookMapper {
	int addBook(Book book);
	Book getBookById(Integer id);

}
