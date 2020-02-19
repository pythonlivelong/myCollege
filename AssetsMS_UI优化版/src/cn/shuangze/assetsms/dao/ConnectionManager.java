/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.shuangze.assetsms.dao;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author Jinyu
 */
public class ConnectionManager {
     public static Connection getConnection() throws Exception
   {    
     
      String driver = "com.mysql.cj.jdbc.Driver";
      Class.forName(driver);
      String url = "jdbc:mysql://localhost:3306/assetsdb?useUnicode=true&characterEncoding=utf8&serverTimezone=Shanghai&useSSL=false";//"jdbc:mysql://localhost:3306/assetsdb";
      String username = "javauser";
      String password = "javauser";
      /*
      Properties props = new Properties();
      try (InputStream in = Files.newInputStream(Paths.get("database.properties")))
      {
         props.load(in);
      }
     
      String drivers = props.getProperty("jdbc.drivers");
      if (drivers != null) {
          Class.forName(driver);
      }
      String url = props.getProperty("jdbc.url");
      String username = props.getProperty("jdbc.username");
      String password = props.getProperty("jdbc.password");
      */

      return DriverManager.getConnection(url, username, password);
   }
    
}
