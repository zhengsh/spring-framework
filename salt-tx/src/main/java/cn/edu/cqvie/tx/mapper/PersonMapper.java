package cn.edu.cqvie.tx.mapper;

import cn.edu.cqvie.tx.domain.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * 用户信息
 *
 * @author zhengsh
 * @date 2020-11-13
 */
public interface PersonMapper {

	/**
	 * 新增入库
	 *
	 * @param person 用户信息
	 */
	@Insert("INSERT `person` (`type`, `user_name`, `birthday`) VALUES (#{type}, #{username}, #{birthday});")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void insert(Person person);
}
