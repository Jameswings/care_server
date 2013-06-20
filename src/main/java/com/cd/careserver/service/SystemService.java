package com.cd.careserver.service;

import com.cd.careserver.po.User;

public interface SystemService {

	User login(int type, String username, String pwd);

}
