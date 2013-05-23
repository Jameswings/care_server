package com.cd.careserver.service;

import com.cd.careserver.po.User;

public interface SystemService {

	User login(String username, String pwd);

}
