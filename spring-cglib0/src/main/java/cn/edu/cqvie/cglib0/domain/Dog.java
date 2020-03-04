package cn.edu.cqvie.cglib0.domain;

import java.io.Serializable;

public class Dog implements Serializable {

	private static final long serialVersionUID = -937360959302657656L;

	private Long id;

	private String name;

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
}
