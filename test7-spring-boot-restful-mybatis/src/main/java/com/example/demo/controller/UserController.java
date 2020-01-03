package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public boolean addUser(User user) {
		System.out.println("开始增加用户");
		userService.addUser(user);
		return true;
	}
    @RequestMapping(value = "/user",method =RequestMethod.PUT )
    public boolean updateUser(User user){
        System.out.println("开始更新用户");
        return userService.updateUser(user);
    }
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "id",required = true) int id){
        System.out.println("开始删除用户");
        return userService.deleteUser(id);
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User findByUserName(@RequestParam(value = "userName",required = true) String userName){
        System.out.println("开始根据用户名字进行查找");
        return userService.findUserByName(userName);
    }
    @RequestMapping(value = "/findall",method = RequestMethod.GET)
    public List<User> findAll(){
        System.out.println("开始查找所有用户");
        return userService.findAll();
    }


}
