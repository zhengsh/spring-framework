package cn.edu.cqvie.tx.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 数据源信息配置
 *
 * @author zhengsh
 * @date 2020-11-13
 */
@Configuration
@MapperScan(basePackages = "cn.edu.cqvie.tx.mapper")
public class DataSourceConfig {

	/**
	 * 数据源配置
	 *
	 * @return 数据源
	 */
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/slat-tx?useSSL=false&characterEncoding=UTF-8&useUnicode=true&serverTimezone=Asia/Shanghai");
		dataSource.setUsername("root");
		dataSource.setPassword("zhh359#");
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

	/**
	 * SqlSession 工厂
	 *
	 * @return SqlSessionFactoryBean
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return sessionFactory;
	}
}
