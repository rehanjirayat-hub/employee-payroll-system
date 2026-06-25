package com.rehan.payroll.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionManager {

    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Properties properties = new Properties();

            InputStream inputStream = ConnectionManager.class
                    .getClassLoader()
                    .getResourceAsStream("db.properties");

            if (inputStream == null) {
                throw new RuntimeException("db.properties file not found.");
            }

            properties.load(inputStream);

            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");

        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException("Failed to initialize database connection.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                url,
                username,
                password
        );
    }

    public static void closeConnection(Connection connection, Statement statement) throws SQLException {

        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
}