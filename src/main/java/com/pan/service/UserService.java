package com.pan.service;

import com.pan.pojo.User;

public interface UserService {
	
	User findByName(String name);
	
	User findById(Integer id);
}
