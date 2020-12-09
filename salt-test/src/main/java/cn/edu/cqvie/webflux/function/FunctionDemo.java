package cn.edu.cqvie.webflux.function;

import java.util.function.Consumer;

public class FunctionDemo {

	public static void main(String[] args) {
		// Consumer 只有输入T 没有输出
		User u = new User();

		Consumer p = user -> User.print();

		// Supplier 没有输入 只有输出R
		//Supplier<User> s = User::new;

		// Function 一个输入T， 一个输出 R
		//Function<Integer, Integer> fun = u::

		// 一元 输入输出类型都是 T
		//UnaryOperator < Integer >

		// 二元函数
		//BiFunction
	}


}

class User {
	private Long id = 100L;

	private String name = "张三";

	private Integer age = 18;


	public User() {

	}

	public static String print() {
		System.out.println("print invoke!");
		return null;
	}

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}