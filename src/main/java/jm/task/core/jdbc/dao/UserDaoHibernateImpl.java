package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = Util.getSession();
        session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (\n" +
                "                    \t  id INTEGER auto_increment primary KEY ,\n" +
                "                        name varchar(20),\n" +
                "                        lastName varchar(20),\n" +
                "                        age integer(3))");
        session.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSession();
        session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS users");
        session.getTransaction().commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSession();
        session.beginTransaction();
        session.save(new User(name, lastName, age));
        session.getTransaction().commit();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {

        return null;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession();
        session.beginTransaction();
        session.createSQLQuery("TRUNCATE TABLE users");
        session.beginTransaction().commit();

    }
}
