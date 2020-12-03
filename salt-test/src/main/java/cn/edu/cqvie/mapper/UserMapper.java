package cn.edu.cqvie.mapper;

import cn.edu.cqvie.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	void insert(User user);
}
