package cn.edu.cqvie.cglib0.beans.factory;

import cn.edu.cqvie.cglib0.service.DogService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhengsh
 * @date 2020-11-12
 */
//@Component
public class SanFactoryBean implements FactoryBean<DogService> {

	@Override
	public DogService getObject() throws Exception {
		System.out.println("SanFactoryBean Print Log info by Create Bean");
		return new DogService();
	}

	@Override
	public Class<?> getObjectType() {
		return DogService.class;
	}
}
