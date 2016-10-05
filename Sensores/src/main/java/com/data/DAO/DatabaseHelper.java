package com.data.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseHelper{
    private final String dbURL = "jdbc:mysql://localhost:3306/Sensores";
    private final String username = "sensores";
    private final String password = "sensores1234";

    public Connection getConnection() throws SQLException {
       return DriverManager.getConnection(dbURL, this.username, this.password);
    }

}
