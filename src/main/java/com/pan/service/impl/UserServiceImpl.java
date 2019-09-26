package com.pan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.dao.UserMapper;
import com.pan.pojo.User;
import com.pan.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByName(String name) {
		return userMapper.findByName(name);
	}
	
	@Override
	public User findById(Integer id) {
		return userMapper.findById(id);
	}

}
