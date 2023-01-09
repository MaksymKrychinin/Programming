package com.lab4EE.Model.Entities;

import java.util.List;

public class Market {
    public String marketName;
    Item item;

    public Market(String marketName, Item item) {
        this.item = item;
        this.marketName = marketName;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

}
