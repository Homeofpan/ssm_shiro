package com.pan.dao;

import com.pan.pojo.User;

public interface UserMapper {

	User findByName(String name);
	
	User findById(Integer id);
}
