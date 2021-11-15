package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();
        System.out.println("Таблица создана");

        User user1 = new User("Stephen", "Strange", (byte) 43);
        userDao.saveUser("Stephen", "Strange", (byte) 43);
        System.out.println("User с именем - " + user1.getName() + " добавлен в базу данных");

        User user2 = new User("Peter", "Parker", (byte) 16);
        userDao.saveUser("Peter", "Parker", (byte) 16);
        System.out.println("User с именем - " + user2.getName() + " добавлен в базу данных");

        User user3 = new User("Wanda", "Maximoff", (byte) 25);
        userDao.saveUser("Wanda", "Maximoff", (byte) 25);
        System.out.println("User с именем - " + user3.getName() + " добавлен в базу данных");

        User user4 = new User("Sam", "Wilson", (byte) 35);
        userDao.saveUser("Sam", "Wilson", (byte) 35);
        System.out.println("User с именем - " + user4.getName() + " добавлен в базу данных");

        List<User> userList = userDao.getAllUsers();
        userList.stream().map(User::toString).forEach(System.out::println);

        userDao.cleanUsersTable();
        System.out.println("Таблица очищена");

        userDao.dropUsersTable();
        System.out.println("Таблица удалена");
    }
}
