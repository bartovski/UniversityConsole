package com.burkovskiy.university.console.dao;

import com.burkovskiy.university.console.util.PropertiesHolder;

import java.sql.*;

public class DatabaseConnection {

    public DatabaseConnection() {
        try {
            Class.forName(PropertiesHolder.get("jdbc.driverClass"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                PropertiesHolder.get("jdbc.url"),
                PropertiesHolder.get("jdbc.username"),
                PropertiesHolder.get("jdbc.password"));
        return connection;
    }


}
