package com.example.autoRent.Model.DAO;

import com.example.autoRent.Model.Entity.Car;
import com.example.autoRent.Model.Entity.User;

import java.util.List;

public interface AdminDAO {
    List<Car> getAllCars();
    boolean addCar(Car car);
    boolean deleteCar(int idCar);
    boolean editCar(Car car);
    List<User> getAllUsers();
    boolean addManager(User user);
    boolean banUser(int idUser);
    boolean unbanUser(int idUser);
}
