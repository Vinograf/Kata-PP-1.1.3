package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import javax.persistence.Id;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {

    Connection connection = getConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Statement statement = null;
        String create = "CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20), age INT)";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(create);
        } catch (SQLException e) {
            ;
        }
    }

    public void dropUsersTable() {
        Statement statement = null;
        String create =
                "DROP TABLE users;";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(create);
        } catch (SQLException e) {
            ;
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        PreparedStatement preparedStatement = null;
        String save = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(save);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
    PreparedStatement preparedStatement = null;
    String remove = "DELETE FROM users WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(remove);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();
        String getAll = " Select id, name , lastName , age from users";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAll);
            while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("lastName"));
            user.setAge(resultSet.getByte("age"));
            userList.add(user);}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return userList;
    }

    public void cleanUsersTable() {

        Statement statement = null;
        String clean = "TRUNCATE TABLE  users ";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(clean);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
