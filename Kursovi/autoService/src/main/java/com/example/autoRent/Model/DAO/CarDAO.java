package com.example.autoRent.Model.DAO;

import com.example.autoRent.Model.Entity.Car;

import java.util.List;

public interface CarDAO {
    Car getCarById(int id);
    List<Car> allCars();
    List<Car> allCarsSortedByName();
    List<Car> allCarsSortedByNameDESC();
    List<Car> allCarsSortedByPrice();
    List<Car> allCarsSortedByPriceDESC();
    List<Car> carsByBrand(String brand);
    List<Car> carsByClass(String carClass);
    List<Car> carsByPrice(double start, double end);
}
