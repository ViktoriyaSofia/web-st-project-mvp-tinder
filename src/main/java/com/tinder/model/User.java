package com.tinder.model;

import java.util.*;

public class User {
  private Long userId;
  private String login;
  private String password;
  private String onlineStatus;
  private String userName;
  private int age;
  private String aboutSelf;
  private String pictureSrc;

  public User(Long userId, String userName, int age, String login, String password) {
    this.userId = userId;
    this.userName = userName;
    this.age = age;
    this.login = login;
    this.password = password;
  }

  public User(Long userId, String login, String password, String onlineStatus,
              String userName, int age, String aboutSelf, String pictureSrc) {
    this.userId = userId;
    this.login = login;
    this.password = password;
    this.onlineStatus = onlineStatus;
    this.userName = userName;
    this.age = age;
    this.aboutSelf = aboutSelf;
    this.pictureSrc = pictureSrc;
  }

  public Long getUserId() {
    return userId;
  }
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getOnlineStatus() {
    return onlineStatus;
  }
  public void setOnlineStatus(String onlineStatus) {
    this.onlineStatus = onlineStatus;
  }

  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }

  public String getAboutSelf() {
    return aboutSelf;
  }
  public void setAboutSelf(String aboutSelf) {
    this.aboutSelf = aboutSelf;
  }

  public String getPictureSrc() {
    return pictureSrc;
  }
  public void setPictureSrc(String pictureSrc) {
    this.pictureSrc = pictureSrc;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return getUserId().equals(user.getUserId()) && getLogin().equals(user.getLogin()) && getPassword().equals(user.getPassword());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUserId(), getLogin(), getPassword());
  }

  @Override
  public String toString() {
    return "User{" +
        "userId=" + userId +
        ", onlineStatus='" + onlineStatus + '\'' +
        ", userName='" + userName + '\'' +
        ", age=" + age +
        ", aboutSelf='" + aboutSelf + '\'' +
        '}';
  }

}