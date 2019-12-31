package com.example.demo2.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public String getUserById(Integer id) {
		System.out.println("get...");
		return "user";
	}
	public void DeleteUserById(Integer id) {
		System.out.println("delete");
	
	}

}
