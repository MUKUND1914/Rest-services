package com.projectboot.spring.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projectboot.spring.model.User;
@Service
public class UserServiceImp implements UserService {

	@Override
	public List<User> getAllUser() {
		
		return this.users;
	}

	private static List<User> users;
	
	public UserServiceImp() {
		users=new LinkedList<User>();
		users.add(new User(1,"mukund"));
		users.add(new User(2,"Yukesh"));
	}

	@Override
	public User getUserById(Integer userid) {
		
		return users.stream().filter(x ->x.getUserid() == userid).findAny().orElse(new User(0, "Not Avaliable"));
	}

	@Override
	public void createUser(Integer userid, String username) {
		User u=new User(userid, username);
		this.users.add(u);
		
	}

	@Override
	public void updateUser(Integer userid, String username) {
		users.stream().filter(x ->x.getUserid()==userid).findAny().orElseThrow( () -> new RuntimeException("Item not found")).setUsername(username);
		
	}

	@Override
	public void deleteUser(Integer userid) {
	
		users.removeIf((User u) ->u.getUserid()==userid);
	}
}
