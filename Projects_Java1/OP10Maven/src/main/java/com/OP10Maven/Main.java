package com.OP10Maven;

public class Main {

    public static void main(String[] args) {
        ItemsDao finder =new ItemsSearcher();
        System.out.println(finder.minItemPrice("Xiaomi"));

        ItemsDao finder1 =new ItemsSearcher();
        System.out.println(finder1.findMarketMinItemPrice("Xiaomi"));

        ItemsDao finder2 =new ItemsSearcher();
        System.out.println(finder2.isMarketWithPriceLowerThanStock());
        //MIn price String "Xiaomi"
        //Find markets String "Xiaomi"
        //Find True of false that price of object in
        // one of markets can be lower than stock price
    }
}

