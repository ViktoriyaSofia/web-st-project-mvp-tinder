package com.tinder.dao;

import org.postgresql.ds.PGPoolingDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tinder.model.User;

public class UserJdbcDao implements UserDao{
  private PGPoolingDataSource source;
  public UserJdbcDao() {
    source = new SourceUtil().getSource();
  }

  public PGPoolingDataSource getSource() {
    return this.source;
  }

  @Override
  public boolean create(User user) {
    Connection connection = null;
    try {
      connection = source.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement(
          "INSERT INTO users.users(name, age, login, password) VALUES (?, ?, ?, ?)");
      preparedStatement.setString(1, user.getUserName());
      preparedStatement.setInt(2, user.getAge());
      preparedStatement.setString(3, user.getLogin());
      preparedStatement.setString(4, user.getPassword());

      int executionResult = preparedStatement.executeUpdate();
      return executionResult > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      if (connection != null) {
        try {
          connection.rollback();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }
    return false;
  }

  @Override
  public User read(Long userId) {
    Connection connection = null;
    try {
      connection = source.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement(
          "SELECT user_id, login, password, is_online, name, age, about_self, picture_src, " +
              "AGE(CURRENT_TIMESTAMP(0), log_out_date) as last_online FROM users.users WHERE user_id=?");
      preparedStatement.setString(1,  String.valueOf(userId));

      ResultSet resultSet = preparedStatement.executeQuery();

      if(resultSet.next()) {
        long id = resultSet.getLong("user_id");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        boolean isOnline = resultSet.getBoolean("is_online");
        String onlineStatus;
        if(isOnline) {
          onlineStatus = "Online now";
        } else {
          onlineStatus = "Last seen "  + resultSet.getString("last_online") + " ago";
        }
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String aboutSelf = resultSet.getString("about_self");
        String pictureSrc = resultSet.getString("picture_src");

        return new User(id, login, password, onlineStatus, name, age, aboutSelf, pictureSrc);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      if (connection != null) {
        try {
          connection.rollback();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }
    return null;
  }

  @Override
  public void update(User user) {
    Connection connection = null;
    try {
      connection = source.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement(
          "UPDATE users.users SET login=?, password=?, log_in_date = now(), is_online = true, " +
              "name=?, age=?, about_self=?, picture_src=? WHERE id=?");
      preparedStatement.setString(1, user.getLogin());
      preparedStatement.setString(2, user.getPassword());
      preparedStatement.setString(3, user.getUserName());
      preparedStatement.setInt(4, user.getAge());
      preparedStatement.setString(5, user.getAboutSelf());
      preparedStatement.setString(6, user.getPictureSrc());
      preparedStatement.setLong(7, user.getUserId());

      int executionResult = preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
      if (connection != null) {
        try {
          connection.rollback();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }
  }

  @Override
  public List<User> findAll() {
    List<User> users = new ArrayList<>();
    Connection connection = null;
    try {
      connection = source.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement(
      "SELECT user_id, login, password, is_online, name, age, about_self, picture_src, " +
          "AGE(CURRENT_TIMESTAMP(0), log_out_date) as last_online FROM users.users"
      );

      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()) {
        long id = resultSet.getLong("user_id");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        boolean isOnline = resultSet.getBoolean("is_online");
        String onlineStatus;
        if(isOnline) {
          onlineStatus = "Online now";
        } else {
          onlineStatus = "Last seen "  + resultSet.getString("last_online") + " ago";
        }
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String aboutSelf = resultSet.getString("about_self");
        String pictureSrc = resultSet.getString("picture_src");

        users.add(new User(id, login, password, onlineStatus, name, age, aboutSelf, pictureSrc));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }
    return users;
  }

  @Override
  public User findByLoginPass(String loginUser, String passwordUser) {
    Connection connection = null;
    try {
      connection = source.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(
          "SELECT user_id, login, password, is_online, name, age, about_self, picture_src, " +
              "AGE(CURRENT_TIMESTAMP(0), log_out_date) as last_online FROM users.users WHERE login=? AND password=?");
      preparedStatement.setString(1, loginUser);
      preparedStatement.setString(2, passwordUser);

      ResultSet resultSet = preparedStatement.executeQuery();
      if(resultSet.next()) {
        long id = resultSet.getLong("user_id");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        boolean isOnline = resultSet.getBoolean("is_online");
        String onlineStatus;
        if(isOnline) {
          onlineStatus = "Online now";
        } else {
          onlineStatus = "Last seen "  + resultSet.getString("last_online") + " ago";
        }
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String aboutSelf = resultSet.getString("about_self");
        String pictureSrc = resultSet.getString("picture_src");

        return new User(id, login, password, onlineStatus, name, age, aboutSelf, pictureSrc);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }
    return null;
  }

}