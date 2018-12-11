package polaris.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import polaris.entity.User;

@Mapper
public interface UserMapper {
	List<Map<String,Object>> queryUsers();
	List<User> queryAllUsers();
}
