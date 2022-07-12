package com.tinder.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.tinder.service.UserService;

public class ProfilesServlet extends HttpServlet {
  private UserService userService;
  private TemplateEngine templateEngine;
  public ProfilesServlet(UserService userService, TemplateEngine templateEngine) {
    this.userService = userService;
    this.templateEngine = templateEngine;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Long activeUserid = (Long) req.getAttribute("id");
    HashMap<String, Object> data = new HashMap<>(1);
    data.put("users", userService.findNewProfiles(activeUserid));
    templateEngine.render("new-profiles.ftl", data, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Long activeUserid = (Long) req.getAttribute("id");
    HashMap<String, Object> data = new HashMap<>(1);
    data.put("users", userService.findNewProfiles(activeUserid));
    templateEngine.render("new-profiles.ftl", data, resp);
  }

}