package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	
	boolean addUser(User user);
	
	 /***
     * 修改用户信息
     * @param user
     * @return
     *
     */
    boolean updateUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     *
     */
    boolean deleteUser(int user);

    /**
     * 根据用户名字查询用户
     * @param username
     * @return
     */
    User findUserByName(String username);

    /**
     * 查询所有
     * @return
     *
     */
    List<User> findAll();


}
