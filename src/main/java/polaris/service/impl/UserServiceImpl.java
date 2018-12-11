package polaris.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import polaris.entity.User;
import polaris.mapper.UserMapper;
import polaris.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userMapper")
	private UserMapper mapper;
	
	@Override
	public List<Map<String,Object>> queryUsers() {
		return mapper.queryUsers();
	}
	@Override
	public List<User> queryAllUsers() {
		return mapper.queryAllUsers();
	}

}
