package com.tinder.service;

import org.postgresql.ds.PGPoolingDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tinder.dao.UserDao;
import com.tinder.dao.SourceUtil;
import com.tinder.model.User;

public class UserJdbcService implements UserService{
  private UserDao userDao;
  private PGPoolingDataSource source;
  public UserJdbcService(UserDao userDao) {
    this.userDao = userDao;
    source = new SourceUtil().getSource();
  }


  @Override
  public boolean create(User user) {
    return userDao.create(user);
  }

  @Override
  public User read(Long id) {
    return userDao.read(id);
  }

  @Override
  public void update(User user) {
    userDao.update(user);
  }

  @Override
  public List<User> findAll() {
    return userDao.findAll();
  }

  @Override
  public User findByLoginPass(String login, String password) {
    return userDao.findByLoginPass(login, password);
  }


//  _____________________________________________________________________________________________________________
  public boolean updateOnlineStatus(long id, boolean isLoginIn) {
    Connection connection = null;
    try {
      connection = source.getConnection();

      PreparedStatement preparedStatement;
            if(isLoginIn){
              preparedStatement = connection.prepareStatement(
                  "UPDATE users.users SET log_in_date = now(), is_online = true WHERE user_id = ?");
              preparedStatement.setLong(1, id);
            } else {
              preparedStatement = connection.prepareStatement(
                  "UPDATE users.users SET log_out_date = now(), is_online = false WHERE user_id = ?");
              preparedStatement.setLong(1, id);
            }

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

  public List<User> findNewProfiles(long activeUserId) {
      List<User> users = new ArrayList<>();
      Connection connection = null;
      try {
        connection = source.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT user_id, login, password, is_online, name, age, about_self, picture_src, " +
                "AGE(CURRENT_TIMESTAMP(0), log_out_date) as last_online \n" +
                "FROM users.users \n" +
                "WHERE user_id <> ? AND user_id NOT IN\n" +
                "\t(SELECT DISTINCT whom_like_id \n" +
                "\t FROM users.likes \n" +
                " \t WHERE who_like_id = ? AND is_liked = true);"
        );
        preparedStatement.setLong(1, activeUserId);
        preparedStatement.setLong(2, activeUserId);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
          long id = resultSet.getLong("user_id");
          String login = resultSet.getString("login");
          String password = resultSet.getString("password");
          boolean isOnline = resultSet.getBoolean("is_online");
          String onlineStatus;
          if (isOnline) {
            onlineStatus = "Online now";
          } else {
            onlineStatus = "Last seen " + resultSet.getString("last_online") + " ago";
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

}