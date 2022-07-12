package com.tinder;

import com.tinder.controller.*;
import com.tinder.dao.UserJdbcDao;
import com.tinder.service.UserJdbcService;
import com.tinder.service.UserService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

public class JettyRun {
  public static void main(String[] args) throws Exception {
    String portStr = System.getenv("PORT");
    String dbUrl = System.getenv("JDBC_DATABASE_URL");
    String username = System.getenv("JDBC_DATABASE_USERNAME");
    String password = System.getenv("JDBC_DATABASE_PASSWORD");
    portStr = portStr == null ? "8088" : portStr;
    Integer port = Integer.parseInt(portStr);
    System.out.println("PORT: " + port);

    Server server = new Server(port);
    ServletContextHandler handler = new ServletContextHandler();

//    UserDao userDao = new UserJdbcDao();
//    UserService userService = new DefaultUserService(userDao);
    UserService userService = new UserJdbcService(new UserJdbcDao());

    TemplateEngine templateEngine = new TemplateEngine();


    handler.addServlet(new ServletHolder(new FileServlet()), "/assets/*");

    handler.addFilter(new FilterHolder(new LoginFilter(templateEngine, userService)), "/*", EnumSet.of(DispatcherType.REQUEST));

    handler.addServlet(new ServletHolder(new TinderWelcomeServlet(templateEngine)), "/");

    handler.addServlet(new ServletHolder(new RegistrationServlet(userService, templateEngine)), "/create");

    handler.addServlet(new ServletHolder(new LoginServlet(templateEngine)), "/login");

    handler.addServlet(new ServletHolder(new ProfilesServlet(userService, templateEngine)), "/profiles");

    handler.addServlet(new ServletHolder(new FriendsServlet(templateEngine)), "/friends");

    handler.addServlet(new ServletHolder(new TinderWelcomeServlet(templateEngine)), "/tinder");

    handler.addServlet(new ServletHolder(new LogoutServlet(userService)), "/logout");

    server.setHandler(handler);
    server.start();
    server.join();
  }

  private static Path ensureDirExists(String dirName) {
    Path dir = Paths.get(dirName).toAbsolutePath();

    if (!Files.exists(dir)) {
      try {
        Files.createDirectories(dir);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return dir;
  }

}