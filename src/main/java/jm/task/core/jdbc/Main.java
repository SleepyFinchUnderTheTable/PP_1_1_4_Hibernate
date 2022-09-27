package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//
//        // создание подключение / выбрасывание искл. при ошибке
//        // создание выполнятора всех комманд (statement)
//        try {
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/testdb",
//                    "root", "admin");
//
//            Statement statement = connection.createStatement();
//            statement.execute("insert into users (name, lastName, age) values ( 'Viktor', 'Dondar', '31');");
//            statement.executeUpdate("update users set age = '21' where id = 1");
////
////            statement.execute("create ");
//
//            UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//            userDaoJDBC.getAllUsers();
//
////            if (!connection.isClosed()) {
////                System.out.println("Connection established");
////            }
////            connection.close();
////            if (connection.isClosed()) {
////                System.out.println("Connection closed");
////            }
//
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }

    }
}
