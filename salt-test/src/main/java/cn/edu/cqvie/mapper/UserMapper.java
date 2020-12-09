package cn.edu.cqvie.mapper;

import cn.edu.cqvie.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * 用户信息操作
 *
 * @author zhengsh
 * @date 2020-12-3
 */
@Mapper
public interface UserMapper {

	/**
	 * 新增
	 * @param user 用户信息
	 * @return 受影响的行数
	 */
	@Insert("insert into user(name, age) values(#{name}, #{age})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int insert(User user);
}
