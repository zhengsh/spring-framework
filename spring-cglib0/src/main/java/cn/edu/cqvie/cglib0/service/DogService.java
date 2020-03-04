package cn.edu.cqvie.cglib0.service;

import cn.edu.cqvie.cglib0.domain.Dog;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DogService {

	public List<Dog> query() {
		Dog dog = new Dog();
		dog.setId(1L);
		dog.setName("Mine");
		return Arrays.asList(dog);
	}
}
