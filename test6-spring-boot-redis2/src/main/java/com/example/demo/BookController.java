package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	StringRedisTemplate StringRedisTemplate;
	
	@GetMapping("/hello")
	public void hello() {
		
		//保存string
		ValueOperations<String	,String> ops1 = StringRedisTemplate.opsForValue();
		ops1.set("name","sanguo");
		String name = ops1.get("name");
		System.out.println(name);
		
		//保存对象
		ValueOperations ops2 = redisTemplate.opsForValue();
		Book b1= new Book();
		b1.setId(1);
		b1.setName("sanguo");
		b1.setAuthor("shinaian");
		
		ops2.set("b1",b1);
		Book b3=(Book)ops2.get("b1");
		
		System.out.println(b3.getAuthor());
	
		
		
		
		
	}
		

}
