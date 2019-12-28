package com.example.demo2;




import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

	@GetMapping("/book")
	public Book books() {
		
		Book b1 = new Book();
		b1.setId(1);
		b1.setAuthor("author1");
		b1.setName("name1");
		b1.setPrice((float) 1.001);
		b1.setPublicationDate(new Date());
		return b1;
	}
	
}
