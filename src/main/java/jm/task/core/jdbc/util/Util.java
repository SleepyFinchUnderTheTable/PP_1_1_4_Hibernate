package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Environment;
//import org.hibernate.service.ServiceRegistry;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


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

    private static SessionFactory sessionFactory = new Configuration().addAnnotatedClass(User.class).buildSessionFactory();
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
