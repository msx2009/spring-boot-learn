package com.example.demo.dao;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
@CacheConfig(cacheNames = "book_cache")
public class BookDao {
	@Cacheable
	public Book getBookById(Integer id) {
		System.out.println("getBookById");
		Book b1 = new Book();
		b1.setId(id);
		b1.setAuthor("luoguanzhong");
		b1.setName("sanguo");
		
		return b1;
	
	}
	
	@CachePut(key="#book.id")//CachePut用于更新一个缓存
	public Book updateBookById(Book book) {
		System.out.println("updateBookById");
		book.setName("sanguo2");
		return book;
		
	}
	
	@CacheEvict(key = "#id")//CacheEvict用于删除缓存，表示移除一个key对应的缓存
	public void deleteBookById(Integer id) {
		System.out.println("deleteBookById");
		
	}
}
