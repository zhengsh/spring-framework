package cn.edu.cqvie.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * MyBatis 配置信息
 *
 * @author zhengsh
 */
@Configuration
public class MyBatisConfig {

	/**
	 * Session 工厂配置
	 *
	 * @param dataSource 数据源
	 * @return Session 工厂
	 * @throws Exception 异常信息
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		return factoryBean.getObject();
	}

	/**
	 * 数据源配置
	 *
	 * @return 数据源
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/slat-tx?useSSL=false&characterEncoding=UTF-8&useUnicode=true&serverTimezone=Asia/Shanghai");
		dataSource.setUsername("root");
		dataSource.setPassword("zhh359#");
		//dataSource.setPassword("root123");
		dataSource.setInitialSize(5);
		dataSource.setMaxActive(10);
		return dataSource;
	}

	/**
	 * 事务管理器配置
	 *
	 * @return 事务管理器
	 */
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
