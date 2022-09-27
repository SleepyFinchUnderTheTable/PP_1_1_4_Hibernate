package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = Util.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            String sqlDltTable = """
                    CREATE TABLE IF NOT EXISTS users (
                    \t  id INTEGER auto_increment primary KEY ,
                        name varchar(20),
                        lastName varchar(20),
                        age integer(3));""";

            statement.executeUpdate(sqlDltTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sqlDropTblUsrs = "DROP TABLE IF EXISTS users";
        try (Connection connection = Util.getInstance().getConnection();
             Statement statement = connection.createStatement()){

            statement.execute(sqlDropTblUsrs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sqlSaveUsr = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        try (Connection connection = Util.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlSaveUsr)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sqlDltByID = "DELETE FROM users WHERE id = ?";
        try (Connection connection = Util.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlDltByID)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        try (Connection connection = Util.getInstance().getConnection();
             Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT name, lastName, age FROM users");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");

                usersList.add(new User(name, lastName, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public void cleanUsersTable() {
        String sqlCleanUsrTbl = "TRUNCATE TABLE users";
        try (Connection connection = Util.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sqlCleanUsrTbl);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}








