package com.lab4EE.Model.Entities;

public class Item {
    String itemName;
    double itemPrice;
    double itemRecommendedPrice;

    public Item(String itemName, double price) {
        this.itemName = itemName;
        this.itemPrice = price;
    }

    public Item(String itemName, double price, double recommendedPrice) {
        this.itemName = itemName;
        this.itemPrice = price;
        this.itemRecommendedPrice = recommendedPrice;
    }

    public double getItemRecommendedPrice() {
        return itemRecommendedPrice;
    }

    public void setItemRecommendedPrice(double itemRecommendedPrice) {
        this.itemRecommendedPrice = itemRecommendedPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
