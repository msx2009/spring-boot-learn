package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
class Test9SpringBootEhcacheApplicationTests {

	@Autowired
	BookDao bookDao;
	
	@Test
	void contextLoads() {
		//第一次执行方法
		Book b1=bookDao.getBookById(1);
		System.out.println(b1.toString());
		//第二次不执行，因为有缓存
		Book b2 = bookDao.getBookById(1);
		System.out.println(b2.toString());
		
		//删除key=1对应的缓存
		bookDao.deleteBookById(1);
		
		Book b3 = bookDao.getBookById(1);
		System.out.println(b3.toString());
		
		Book b4  = new Book();
		b4.setId(1);
		b4.setAuthor("luoguan2");
		b4.setName("sanguo2");
		
		//更新key=1对应的缓存
		bookDao.updateBookById(b4);
		System.out.println(bookDao.getBookById(1));
		
		
		
		
	}
	

}
