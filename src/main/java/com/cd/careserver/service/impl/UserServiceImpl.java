package com.cd.careserver.service.impl;

import com.cd.careserver.dao.UserDao;
import com.cd.careserver.po.User;
import com.cd.careserver.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public String addUser(User user){
		return userDao.insert(user);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
