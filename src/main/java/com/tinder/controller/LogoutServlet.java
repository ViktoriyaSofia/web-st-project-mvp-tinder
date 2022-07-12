package com.tinder.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tinder.service.UserService;
import com.tinder.service.CookieUtil;
import static com.tinder.controller.LoginFilter.USER_PARAM_ID;

public class LogoutServlet extends HttpServlet{
  private UserService userService;
  public LogoutServlet(UserService userService) {
    this.userService = userService;
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    CookieUtil.getCookieByName(request, USER_PARAM_ID)
          .ifPresent(c -> {
            userService.updateOnlineStatus(Long.parseLong(c.getValue()), false);
            c.setMaxAge(0);
            c.setPath("/");
            response.addCookie(c);
          });

    response.sendRedirect("/");
  }

}