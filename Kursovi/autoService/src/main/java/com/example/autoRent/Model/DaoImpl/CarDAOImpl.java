package com.example.autoRent.Model.DaoImpl;

import com.example.autoRent.Model.DAO.CarDAO;
import com.example.autoRent.Model.DataBaseConnectionPool.ConnectionPool;
import com.example.autoRent.Model.Entity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOImpl implements CarDAO {
    private String GET_CARS_BY_ID = "SELECT * FROM autorent.cars where idCar=?;";
    private String GET_ALL_CARS = "SELECT * FROM autorent.cars;";
    private String GET_ALL_CARS_SORTED_BY_NAME = "SELECT * FROM autorent.cars ORDER BY name;";
    private String GET_ALL_CARS_SORTED_BY_NAME_DESC = "SELECT * FROM autorent.cars ORDER BY name DESC;";
    private String GET_ALL_CARS_SORTED_BY_PRICE = "SELECT * FROM autorent.cars ORDER BY costPerHour;";
    private String GET_ALL_CARS_SORTED_BY_PRICE_DESC = "SELECT * FROM autorent.cars ORDER BY costPerHour DESC;";
    private String GET_ALL_CARS_BY_BRAND = "SELECT * FROM autorent.cars where brand=?";
    private String GET_ALL_CARS_BY_CLASS = "SELECT * FROM autorent.cars where qualityClass=?";
    private String GET_ALL_CARS_BY_PRICE = "SELECT * FROM autorent.cars where costPerHour between ? and ?";

    @Override
    public Car getCarById(int id) {
        Car car = null;
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CARS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int idCar = resultSet.getInt("idCar");
                String name = resultSet.getString("name");
                String qualityClass = resultSet.getString("qualityClass");
                double costPerHour = resultSet.getDouble("costPerHour");
                String brand = resultSet.getString("brand");
                car = new Car(idCar, name, qualityClass, costPerHour, brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public List<Car> allCars() {
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
    public List<Car> allCarsSortedByName() {
        List<Car> carList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARS_SORTED_BY_NAME)) {
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
    public List<Car> allCarsSortedByNameDESC() {
        List<Car> carList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARS_SORTED_BY_NAME_DESC)) {
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
    public List<Car> allCarsSortedByPrice() {
        List<Car> carList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARS_SORTED_BY_PRICE)) {
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
    public List<Car> allCarsSortedByPriceDESC() {
        List<Car> carList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARS_SORTED_BY_PRICE_DESC)) {
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
    public List<Car> carsByBrand(String brand) {
        List<Car> carList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARS_BY_BRAND)) {
            preparedStatement.setString(1, brand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCar = resultSet.getInt("idCar");
                String name = resultSet.getString("name");
                String qualityClass = resultSet.getString("qualityClass");
                double costPerHour = resultSet.getDouble("costPerHour");
                Car car = new Car(idCar, name, qualityClass, costPerHour, brand);
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    @Override
    public List<Car> carsByClass(String qualityClass) {
        List<Car> carList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARS_BY_CLASS)) {
            preparedStatement.setString(1, qualityClass);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCar = resultSet.getInt("idCar");
                String name = resultSet.getString("name");
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
    public List<Car> carsByPrice(double start, double end) {
        List<Car> carList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARS_BY_PRICE)) {
            preparedStatement.setDouble(1, start);
            preparedStatement.setDouble(2, end);
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
}
