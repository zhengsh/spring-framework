package cn.edu.cqvie.service;

import cn.edu.cqvie.domain.User;
import cn.edu.cqvie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public void test() {
		System.out.println("user service test method!");
	}

	public void insert(User user) {
		userMapper.insert(user);
	}
}
