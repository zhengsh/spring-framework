package cn.edu.cqvie.domain;

import com.sun.javafx.beans.IDProperty;

/**
 * 用户信息
 *
 * @author zhengsh
 * @date 2020-12-13
 */
public class User {

	private Long id;

	private String name;

	private int age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
