package cn.edu.cqvie.tx.service;


import cn.edu.cqvie.tx.config.ApplicationConfig;
import cn.edu.cqvie.tx.config.DataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class, ApplicationConfig.class})
public class PersonServiceTest {

	@Autowired
	private PersonService personService;

	@Test
	public void test() {
		personService.test();
	}
}
