package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int addBook(Book book) {
		return jdbcTemplate.update("insert into book(name,author) values (?,?)",book.getName(),book.getAuthor());
		
	}

	public Book getBookById(Integer id ) {
		return jdbcTemplate.queryForObject("select * from book where id=?", new BeanPropertyRowMapper<>(Book.class) ,id);
		
	}
}
