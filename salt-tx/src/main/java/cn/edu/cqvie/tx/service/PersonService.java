package cn.edu.cqvie.tx.service;

import cn.edu.cqvie.tx.domain.Person;
import cn.edu.cqvie.tx.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDate;

import static cn.edu.cqvie.tx.domain.Person.TypeEnum.GENERAL;


/**
 * 用户信息业务处理
 *
 * @author zhengsh
 * @date 2020-11-13
 */
@Service
public class PersonService {

	@Autowired
	private PersonMapper personMapper;
	@Autowired
	private PersonService personService;

	/**
	 * 事务测试
	 */
	@Transactional(rollbackFor = RuntimeException.class)
	public void test() {
		System.out.println("test method invoke start");
		Person person = new Person();
		person.setUsername("Tom");
		person.setType((short) GENERAL.ordinal());
		person.setBirthday(LocalDate.now());

		System.out.println("test method invoke start exec sql");
		personMapper.insert(person);
		System.out.println("test method invoke end exec sql");

		//测试1. 在 TransactionSynchronizationManager 中注册 TransactionSynchronization 监听/接受挂起回调
		//如果需要创造挂起条件，需要新开事务
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
			@Override
			public void suspend() {
				System.out.println("被挂起。。。。。");
			}
		});

		person.setUsername("WanKen");
		personService.insert(person);
		System.out.println("test method invoke end");


	}

	/**
	 * 用户信息插入
	 *
	 * @param person 用户信息
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = RuntimeException.class)
	public void insert(Person person) {
		System.out.println("insert method invoke start exec sql");
		personMapper.insert(person);
		System.out.println("insert method invoke end exec sql");
		int s = 0;
		//int a = 100 / s;
	}
}
