package com.projectboot.spring.service;

import java.util.List;

import com.projectboot.spring.model.User;

public interface UserService {
  List<User> getAllUser();
  User getUserById(Integer userid);
  void createUser(Integer userid,String username);
  void updateUser(Integer userid,String username);
  void deleteUser(Integer userid);
}
