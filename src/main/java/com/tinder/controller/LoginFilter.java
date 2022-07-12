package com.tinder.controller;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

import com.tinder.service.UserService;
import com.tinder.service.CookieUtil;
import com.tinder.model.User;


public class LoginFilter implements Filter {
  public static final String USER_PARAM_ID = "id";
  private TemplateEngine templateEngine;
  private UserService userService;
  public LoginFilter(TemplateEngine templateEngine, UserService userService) {
    this.templateEngine = templateEngine;
    this.userService = userService;
  }


  @Override
  public void doFilter(ServletRequest req, ServletResponse resp,
                       FilterChain chain) throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;

    Set<String> allowedUrls = Set.of("/assets", "/", "/tinder", "/login", "/create");
    if (allowedUrls.contains(request.getServletPath())) {
      chain.doFilter(request, response);

    } else {
      Optional<Cookie> optionalCookie = CookieUtil.getCookieByName(request, USER_PARAM_ID);

      if (optionalCookie.isEmpty()) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userService.findByLoginPass(login, password);

        if (user != null) {
          response.addCookie(new Cookie(USER_PARAM_ID, String.valueOf(user.getUserId())));

          request.setAttribute("id", user.getUserId());
          chain.doFilter(request, response);

          userService.updateOnlineStatus(user.getUserId(), true);

        } else {
          templateEngine.render("login.ftl", new HashMap<>(), response);
        }
      } else {
        optionalCookie.ifPresent(c ->
            request.setAttribute("id", Long.parseLong(c.getValue())));
        chain.doFilter(request, response);
      }
    }

  }

  public void init(FilterConfig config) throws ServletException {
  }

  public void destroy() {
  }

}