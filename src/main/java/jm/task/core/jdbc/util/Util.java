package jm.task.core.jdbc.util;

import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    private static final String password = "admin";
    private static final String login = "root";
    private static final String host = "jdbc:mysql://localhost:3306/testdb";
    private static Connection connection;
    private volatile static Util instance;

    public static Connection getConnection() {
        try {
            return connection = DriverManager.getConnection(host, login, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Util getInstance() throws SQLException {
        if (instance == null) {
            synchronized (Util.class) {
                if (instance == null) {
                    instance = new Util();
                }
            }
        }
        return instance;
    }

    Configuration configuration = new Configuration();
}
