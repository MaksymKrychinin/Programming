package com.example.autoRent.Model.Entity;

public class Car {
    int idCar;
    String name;
    String qualityClass;
    double costPerHour;
    String brand;

    public Car(String name, String qualityClass, double costPerHour, String brand) {
        this.name = name;
        this.qualityClass = qualityClass;
        this.costPerHour = costPerHour;
        this.brand = brand;
    }

    public Car() {
    }

    public Car(int idCar, String name, String qualityClass, double costPerHour, String brand) {
        this.idCar = idCar;
        this.name = name;
        this.qualityClass = qualityClass;
        this.costPerHour = costPerHour;
        this.brand = brand;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualityClass() {
        return qualityClass;
    }

    public void setQualityClass(String qualityClass) {
        this.qualityClass = qualityClass;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
