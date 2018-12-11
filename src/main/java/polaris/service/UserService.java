package polaris.service;

import java.util.List;
import java.util.Map;

import polaris.entity.User;

public interface UserService {

	List<Map<String,Object>> queryUsers();
	List<User> queryAllUsers();
}
