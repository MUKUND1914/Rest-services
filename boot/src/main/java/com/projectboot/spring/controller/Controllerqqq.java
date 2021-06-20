package com.projectboot.spring.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectboot.spring.model.User;
import com.projectboot.spring.service.UserService;
import com.projectboot.spring.service.UserServiceImp;

@RestController
@RequestMapping("/helloa")
public class Controllerqqq {
	
	@Autowired
	UserService userservice;
	
	@RequestMapping("")
	public List<User> getalluser() {
		
        return userservice.getAllUser();
	}
	
	@RequestMapping("/{id}")
	public User getUserById(@PathVariable("id") Integer id)
	{
		return userservice.getUserById(id);
	}
	
	@RequestMapping(value = "",method =RequestMethod.POST)
	public Map<String,Object> createUser(@RequestParam(value = "userid") Integer userid,@RequestParam(value = "username") String username)
	{
		Map<String, Object>map=new LinkedHashMap<>();
		userservice.createUser(userid, username);
		map.put("result","added");
		return map;
	}
	
	@RequestMapping(value = "",method = RequestMethod.PUT)
	public Map<String, Object> updateUser(@RequestParam("userid") Integer userid,@RequestParam("username") String username )
	{
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		userservice.updateUser(userid, username);
		map.put("rseult","upadted successfully");
		return map;
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public Map<String, Object> deleteUser(@PathVariable("id") Integer userid )
	{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		userservice.deleteUser(userid);
		map.put("result","deleted successfully");
		return map;
		
	}

}
