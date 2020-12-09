package cn.edu.cqvie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class B {

	@Autowired
	private A a;

	public String test() {
		System.out.println(a.test());
		return "test b";
	}
}
