package cn.edu.cqvie.tx.service;

import cn.edu.cqvie.tx.domain.Person;
import cn.edu.cqvie.tx.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
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
		Person person = new Person();
		person.setUsername("Tom");
		person.setType((short) GENERAL.ordinal());
		person.setBirthday(LocalDate.now());

		personMapper.insert(person);

		person.setUsername("WanKen");
		personService.insert(person);
	}

	/**
	 * 用户信息插入
	 *
	 * @param person 用户信息
	 */
	@Transactional(rollbackFor = RuntimeException.class)
	public void insert(Person person) {
		personMapper.insert(person);
	}
}
