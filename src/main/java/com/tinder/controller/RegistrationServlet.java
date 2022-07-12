package com.tinder.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.tinder.model.User;
import com.tinder.service.UserService;

public class RegistrationServlet extends HttpServlet {
  private UserService userService;
  private TemplateEngine templateEngine;
  public RegistrationServlet(UserService userService, TemplateEngine templateEngine) {
    this.userService = userService;
    this.templateEngine = templateEngine;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    templateEngine.render("registration.ftl", new HashMap<>(), resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    String ageStr = req.getParameter("age");
    String login = req.getParameter("login");
    String password = req.getParameter("password");

    int age = 0;
    try {
      age = Integer.parseInt(ageStr);
    } catch (NumberFormatException e) {
      resp.sendRedirect("/registration");
      return;
    }

    User user = new User(null, name, age, login, password);
    userService.create(user);
    resp.sendRedirect("/login");
  }

}