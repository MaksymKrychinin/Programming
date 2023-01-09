package com.OP10Maven;

public interface ItemsDao {
    double minItemPrice(String Name);

    String findMarketMinItemPrice(String Name);

    boolean isMarketWithPriceLowerThanStock();
}
