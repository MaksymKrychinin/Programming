package DAO;

import DataBaseConnectionPool.ConnectionPool;
import Entity.Task;
import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String SIGN_IN = "SELECT * FROM projectmanagment.users where login=? and password=?;";

   public User signIn(User user){
        User userForReturn=null;
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SIGN_IN)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                userForReturn = new User(id,login,password,surname,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userForReturn;
    }
}
