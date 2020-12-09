package cn.edu.cqvie.service;

import cn.edu.cqvie.domain.User;
import cn.edu.cqvie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;

	public void test() {
		System.out.println("user service test method!");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void test1() {
		User user = new User();
		user.setAge(10);
		user.setName("XiaoMi");
		userMapper.insert(user);

		userService.test2();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void test2() {
		User user = new User();
		user.setAge(20);
		user.setName("HuaWei");
		userMapper.insert(user);
	}
}
