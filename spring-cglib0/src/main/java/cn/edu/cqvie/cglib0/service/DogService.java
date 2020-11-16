package cn.edu.cqvie.cglib0.service;

import cn.edu.cqvie.cglib0.domain.Dog;
import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.Inherited;
import java.util.Arrays;
import java.util.List;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author zhengsh
 */
@Component
@Scope(SCOPE_PROTOTYPE)
@Lazy
public class DogService extends AbstractDogService {

	public List<Dog> query() {
		Dog dog = new Dog();
		dog.setId(1L);
		dog.setName("Mine");
		return Arrays.asList(dog);
	}
}
