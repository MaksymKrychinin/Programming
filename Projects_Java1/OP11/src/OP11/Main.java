package OP11;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        TreeSet<Item> itemsComfy = new TreeSet<>(new SortByPriceToHigh());
        TreeSet<Item> itemsRozetka = new TreeSet<>(new SortByPriceToHigh());

        Item item1 = new Item("Iphone", 1200, 1999);
        Item item2 = new Item("Xiaomi", 600,1299);
        Item item3 = new Item("Huawei", 720,1000);
        itemsComfy.add(item1);
        itemsComfy.add(item2);
        itemsComfy.add(item3);
        Item item4 = new Item("Iphone", 1000,999);
        Item item5 = new Item("Xiaomi", 500,499);
        Item item6 = new Item("Huawei", 620,619);
        itemsRozetka.add(item4);
        itemsRozetka.add(item5);
        itemsRozetka.add(item6);

        TreeSet<Market> markets = new TreeSet<>();
        Market Comfy = new Market("Comfy", itemsComfy);
        Market Rozetka = new Market("Rozetka", itemsRozetka);
        markets.add(Comfy);
        markets.add(Rozetka);


        Searcher searcher = new Searcher(markets);
        System.out.println(searcher.findMinPrice("Xiaomi"));
        System.out.println(searcher.findMarketsWithMinPrice("Iphone"));
        System.out.println(searcher.marketPriceLower());
    }
}

class SortByPriceToHigh implements java.util.Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        return item1.getPrice() < item2.getPrice() ? -1 : item1.getPrice() > item2.getPrice() ? 1 : 0;
    }
}

class Market implements Comparable<Market>{
    public String getMarketName() {
        return marketName;
    }

    private String marketName;
    private TreeSet<Item> items;

    Market(String marketName, TreeSet<Item> items) {
        this.marketName = marketName;
        this.items = items;
    }

    public TreeSet<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Market{" +
                "marketName='" + marketName + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public int compareTo(Market market) {
        return this.marketName.compareTo(market.getMarketName());
    }
}


class Searcher {
    private TreeSet<Market> markets;
    private boolean isMarket=false;


    Searcher(TreeSet<Market> markets) {
        this.markets = markets;
    }


    double findMinPrice(String itemName) {
        TreeSet<Item> temp = new TreeSet<>(new SortByPriceToHigh());
        Iterator<Market> marketsIterator = markets.iterator();
        while (marketsIterator.hasNext()){
            Iterator<Item> itemsInMarketIterator = marketsIterator.next().getItems().iterator();
            while (itemsInMarketIterator.hasNext()){
                Item tmp = itemsInMarketIterator.next();
                if (tmp.getName().equals(itemName)){
                    temp.add(tmp);
                }
            }
        }
        
        return temp.iterator().next().getPrice();
    }


    TreeSet<Market> findMarketsWithMinPrice(String itemName) {
        double minPrice=findMinPrice(itemName);
        TreeSet<Market> temp = new TreeSet<>();
        Iterator<Market> marketsIterator = markets.iterator();
        while (marketsIterator.hasNext()){
            Market market = marketsIterator.next();
            Iterator<Item> itemsInMarketIterator = market.getItems().iterator();
            while (itemsInMarketIterator.hasNext()){
                Item tmp = itemsInMarketIterator.next();
                if (tmp.getName().equals(itemName)){
                    if (tmp.getPrice()==minPrice){
                        temp.add(market);
                    }
                }
            }
        }
        return temp;
    }

    boolean marketPriceLower() {
        Iterator<Market> marketsIterator = markets.iterator();
        while (marketsIterator.hasNext()){
            Iterator<Item> itemsInMarketIterator = marketsIterator.next().getItems().iterator();
            while (itemsInMarketIterator.hasNext()){
                Item tmp = itemsInMarketIterator.next();
                if (tmp.getPrice()<tmp.getStockPrice()){
                    isMarket = true;
                }
            }
        }
        return isMarket;
    }
}

class Item implements Serializable {
    private String name;
    private double price;

    public double getStockPrice() {
        return stockPrice;
    }

    private double stockPrice;

    Item(String name, double price, double stockPrice) {
        this.name = name;
        this.price = price;
        this.stockPrice=stockPrice;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public double getPrice() {
        return price;
    }
}


