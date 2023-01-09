package com.example.autoRent.Model.DaoImpl;

import com.example.autoRent.Model.DAO.AdminDAO;
import com.example.autoRent.Model.DataBaseConnectionPool.ConnectionPool;
import com.example.autoRent.Model.Entity.Car;
import com.example.autoRent.Model.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    private String GET_ALL_CARS = "SELECT * FROM autorent.cars;";
    private String ADD_CAR = "INSERT INTO autorent.cars (`name`, `qualityClass`, `costPerHour`, `brand`) VALUES (?, ?, ?, ?);";
    private String DELETE_CAR = "DELETE FROM autorent.cars where idCar = ?;";
    private String EDIT_CAR = "UPDATE autorent.cars SET name = ?, qualityClass = ?, costPerHour = ?, brand = ? where idCar = ?;";
    private String GET_ALL_USERS = "SELECT * FROM autorent.users;";
    private String ADD_MANAGER = "INSERT INTO `autorent`.`users` (`name`, `surname`, `gender`, `email`, `password`, `dateOfBirthday`, `phoneNumber`, `idrole`) VALUES (?, ?, ?, ?, ?, ?, ?, (SELECT idrole FROM autorent.roles where name='manager' limit 1));";
    private String BAN_USER = "UPDATE users set banStatus=true where iduser = ?;";
    private String UNBAN_USER = "UPDATE users set banStatus=false where iduser = ?";

    @Override
    public List<Car> getAllCars() {
        List<Car> carList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCar = resultSet.getInt("idCar");
                String name = resultSet.getString("name");
                String qualityClass = resultSet.getString("qualityClass");
                double costPerHour = resultSet.getDouble("costPerHour");
                String brand = resultSet.getString("brand");
                Car car = new Car(idCar, name, qualityClass, costPerHour, brand);
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    @Override
    public boolean addCar(Car car) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_CAR)) {
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getQualityClass());
            preparedStatement.setDouble(3, car.getCostPerHour());
            preparedStatement.setString(4, car.getBrand());
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCar(int idCar) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR)) {
            preparedStatement.setInt(1, idCar);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editCar(Car car) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_CAR)) {
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getQualityClass());
            preparedStatement.setDouble(3, car.getCostPerHour());
            preparedStatement.setString(4, car.getBrand());
            preparedStatement.setInt(5, car.getIdCar());
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int iduser = resultSet.getInt("iduser");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                boolean banStatus = resultSet.getBoolean("banStatus");
                User user = new User(iduser, name, surname, email, banStatus);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean addManager(User user) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_MANAGER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setDate(6, user.getDateOfBirthday());
            preparedStatement.setString(7, user.getPhoneNumber());
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean banUser(int idUser) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(BAN_USER)) {
            preparedStatement.setInt(1, idUser);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean unbanUser(int idUser) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UNBAN_USER)) {
            preparedStatement.setInt(1, idUser);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
