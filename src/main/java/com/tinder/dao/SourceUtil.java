package com.tinder.dao;

import org.postgresql.ds.PGPoolingDataSource;

public class SourceUtil {
  private PGPoolingDataSource source;

  public SourceUtil() {
    source = new PGPoolingDataSource();
    source.setServerName("ec2-44-206-89-185.compute-1.amazonaws.com");
    source.setDatabaseName("d510kv5rqp7kj4");
    source.setUser("exngnvawvnrjtl");
    source.setPassword("d4b260ee769bcaf553983c3decac5c8f6b406cd7dcf5d75a369d0372e5b6d0ba");
    source.setMaxConnections(10);
  }

  public PGPoolingDataSource getSource() {
    return source;
  }

}