package com.example.autoRent.Model.DaoImpl;

import com.example.autoRent.Model.DAO.UserDAO;
import com.example.autoRent.Model.DataBaseConnectionPool.ConnectionPool;
import com.example.autoRent.Model.Entity.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    private String SIGN_IN="SELECT u.iduser, u.name, u.surname, u.gender, u.email, u.password, u.dateOfBirthday, u.phoneNumber, r.name as roleName, u.banStatus \n" +
            "FROM autorent.users u \n" +
            "INNER JOIN roles r ON u.idrole=r.idrole\n" +
            "where email=? and password=?;";
    private String REGISTER="INSERT INTO autorent.users (`name`, `surname`, `gender`, `email`, `password`, `dateOfBirthday`, `phoneNumber`) VALUES ('?', '?', '?', '?', '?', '?', '?');";
    @Override
    public User signIn(String email, String password) {
        User user = null;
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SIGN_IN)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int iduser = resultSet.getInt("iduser");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String gender = resultSet.getString("gender");
                Date date = resultSet.getDate("dateOfBirthday");
                String phoneNumber = resultSet.getString("phoneNumber");
                String roleName = resultSet.getString("roleName");
                boolean banStatus = resultSet.getBoolean("banStatus");
                user=new User(iduser, roleName, name, surname, gender, email, password, phoneNumber, date, banStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User register(User user) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REGISTER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setDate(6, user.getDateOfBirthday());
            preparedStatement.setString(7, user.getPhoneNumber());
            if (preparedStatement.executeUpdate()==1){
                return signIn(user.getEmail(), user.getPassword());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
