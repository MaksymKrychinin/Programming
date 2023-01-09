package com.example.lab4.view;

import com.example.lab4.model.Good;

import java.util.Map;

public class GoodView {

    private Good good;

    private Map<String, Double> marketPrice;

    public void setGood(Good good) {
        this.good = good;
    }

    public void setMarketPrice(Map<String, Double> marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Good getGood() {
        return good;
    }

    public Map<String, Double> getMarketPrice() {
        return marketPrice;
    }
}
