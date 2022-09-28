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

//    private static SessionFactory sessionFactory;
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                Configuration configuration = new Configuration();
//
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.URL, host);
//                settings.put(Environment.USER, login);
//                settings.put(Environment.PASS, password);
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
//
//                settings.put(Environment.SHOW_SQL, "true");
//
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
//                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//
//                configuration.setProperties(settings);
//
//                configuration.addAnnotatedClass(User.class);
//
//                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//
//                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return sessionFactory;
//    }


    private static SessionFactory sessionFactory = new Configuration().addAnnotatedClass(User.class).buildSessionFactory();
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
