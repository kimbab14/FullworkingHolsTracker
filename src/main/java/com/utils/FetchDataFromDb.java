package com.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bean.User;
import com.conn.DbConnection;

public class FetchDataFromDb {
  /**
   * get a list of all data from the database
   * @return ls
   */
  public static List<User> GetHolsData() {
    /**
     * Create an instance of a class DbConnection
     */
    DbConnection db = new DbConnection();
    db.getConnection();
    Logger logger = Logger.getAnonymousLogger();
    List<User> ls = new LinkedList<User>();
    try {
      ResultSet rs = db.getCon().prepareStatement("SELECT * FROM jsp ORDER BY ID DESC").executeQuery();
      while (rs.next()) {
        User n = new User(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6) );
        ls.add(n);
      }
    } catch (SQLException e) {
      logger.log(Level.SEVERE, "Please check your MySQL syntax", e);
    }
    return ls;
  }
}