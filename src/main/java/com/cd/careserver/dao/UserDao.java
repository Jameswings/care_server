package com.cd.careserver.dao;

import java.util.List;

import com.cd.careserver.po.User;

public interface UserDao {

	User findById(String userId);

	String insert(User user);

	String delete(String userId);

	String update(User user);

	List<User> findAll();

	User findByUsernameAndPwd(String username, String password);
}
