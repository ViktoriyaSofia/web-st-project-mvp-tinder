package com.tinder.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.tinder.service.CookieUtil;

import static com.tinder.controller.LoginFilter.USER_PARAM_ID;

public class FriendsServlet extends HttpServlet {
  private TemplateEngine templateEngine;
  public FriendsServlet(TemplateEngine templateEngine) {
    this.templateEngine = templateEngine;
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>(1);
    CookieUtil.getCookieByName(request, USER_PARAM_ID)
        .ifPresent(c -> {
          data.put("isOnline", "online");
        });
    templateEngine.render("like-page.ftl", data, response);
  }

}