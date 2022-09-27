package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    private static final String password = "admin";
    private static final String login = "root";
    private static final String host = "jdbc:mysql://localhost:3306/testdb";
    private static Connection connection;
    private static Statement statement;

    public static Connection getConnection() {
        try {
            return connection = DriverManager.getConnection(host, login, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // реализуйте настройку соеденения с БД
}
