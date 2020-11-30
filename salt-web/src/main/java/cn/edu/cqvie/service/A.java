package cn.edu.cqvie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

	@Autowired
	private B b;

	public String test() {
		System.out.println(b.test());
		return "test a";
	}
}
