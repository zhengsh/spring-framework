package cn.edu.cqvie.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhengsh
 */
@Component
public class BFactoryBean implements FactoryBean<B> {

	@Autowired
	private AFactoryBean aFactoryBean;

	@Override
	public B getObject() throws Exception {
		return new B();
	}

	@Override
	public Class<?> getObjectType() {
		return B.class;
	}
}
