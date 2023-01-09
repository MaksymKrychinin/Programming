package com.lab4EE.Model.Entities;

import java.util.ArrayList;
import java.util.List;

public class Service {
    List<Market> marketList;

    public List<Market> getMarketList() {
        return marketList;
    }

    public void addMarketList(Market obj) {
        this.marketList.add(obj);
    }

    public Service() {
        marketList = new ArrayList<>();
    }
}
