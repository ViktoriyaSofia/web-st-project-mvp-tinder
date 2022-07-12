package com.tinder.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
  private TemplateEngine templateEngine;
  public LoginServlet(TemplateEngine templateEngine) {
    this.templateEngine = templateEngine;
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    templateEngine.render("login.ftl", response);
  }

}