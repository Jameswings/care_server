package com.cd.careserver.service.impl;

import com.cd.careserver.dao.UserDao;
import com.cd.careserver.po.User;
import com.cd.careserver.service.SystemService;

public class SystemServiceImpl implements SystemService {

	private UserDao userDao;
	
	public User login(int type, String username, String pwd){
		return userDao.findUser(type, username, pwd);
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
