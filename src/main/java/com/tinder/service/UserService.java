package com.tinder.service;

import java.util.List;
import com.tinder.model.User;

public interface UserService {
  boolean create(User user);

  User read(Long id);

  void update(User user);

  List<User> findAll();

  User findByLoginPass(String login, String password);

  boolean updateOnlineStatus(long id, boolean isLoginIn);

  public List<User> findNewProfiles(long activeUserId);

}