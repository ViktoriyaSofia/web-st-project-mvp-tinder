package com.tinder.dao;

import com.tinder.model.User;
import java.util.List;

public interface UserDao {
  boolean create(User user);

  User read(Long id);

  void update(User user);

  List<User> findAll();

  User findByLoginPass(String login, String password);

}