package com.example.lab4.model;

public class Good implements Comparable<Good>{
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Good o) {
        return name.compareTo(o.getName());
    }
}
