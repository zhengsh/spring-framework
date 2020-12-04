package cn.edu.cqvie.service;

import cn.edu.cqvie.mapper.UserMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhengsh
 */
@Component(value = "a")
public class AFactoryBean implements FactoryBean<A> {

	@Autowired
	private B b;

	@Autowired
	private BFactoryBean bFactoryBean;

	@Override
	public A getObject() throws Exception {
		return new A();
	}

	@Override
	public Class<?> getObjectType() {
		return A.class;
	}
}
