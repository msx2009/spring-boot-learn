package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public boolean addUser(User user) {
		
		userDao.addUser(user);
		return true;
	}
	
    @Override
    public boolean updateUser(User user) {
        boolean flag=false;
        try {
            userDao.updateUser(user);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteUser(int user) {
        boolean flag=false;
        try {
            userDao.deleteUser(user);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User findUserByName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


}
