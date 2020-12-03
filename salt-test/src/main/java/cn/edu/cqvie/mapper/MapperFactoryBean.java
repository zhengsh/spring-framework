package cn.edu.cqvie.mapper;

import cn.edu.cqvie.domain.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Mapper Bean 实现
 *
 * @author zhengsh
 * @date 2020-12-3
 */
@Component
public class MapperFactoryBean implements FactoryBean<UserMapper> {

	private Class<?> clazz = UserMapper.class;

	@Override
	public UserMapper getObject() throws Exception {
		return (UserMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{this.clazz}, (proxy, method, args) -> {
			System.out.println("MapperFactoryBean getObject invoke ! ");
			return null;
		});
	}

	@Override
	public Class<?> getObjectType() {
		return clazz;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
