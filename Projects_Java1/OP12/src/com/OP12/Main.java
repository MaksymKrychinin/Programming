package com.OP12;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        Item item1 = new Item("Iphone", 1200);
        Item item2 = new Item("Xiaomi", 600);
        Item item3 = new Item("Huawei", 720);
        Collections.addAll(items, item1, item2, item3);


        ArrayList<Market> markets = new ArrayList<>();
        Market Comfy = new Market("Comfy", items);
        Market Rozetka = new Market("Rozetka", items);
        Collections.addAll(markets, Comfy, Rozetka);

        Comfy.doPriceMore(-120);
        Rozetka.doPriceMore(130);

        Searcher searcher = new Searcher(markets, items);
        System.out.println(searcher.findMinPrice("Xiaomi"));
        System.out.println(searcher.findMarkets("Iphone"));
        System.out.println(searcher.marketPriceLower());
    }
}


class Market {
    private String marketName;
    private ArrayList<Item> items;

    Market(String marketName, ArrayList<Item> items) {
        this.marketName = marketName;
        this.items = new ArrayList<>(items.size());
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            this.items.add(new Item(iterator.next()));
        }

    }

    void doPriceMore(int count) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item tmp = iterator.next();
            double tmp1 = tmp.getPrice();
            tmp.setPrice((tmp1 + count));
        }
    }


    boolean gotItem(String itemName) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            if (itemName == iterator.next().getName()) {
                return true;
            }
        }
        return false;
    }

    Item getItem(String itemName) {

        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item tmp = iterator.next();
            if (itemName == tmp.getName()) {
                return tmp;
            }
        }
        return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Market{" +
                "marketName='" + marketName + '\'' +
                ", items=" + items +
                '}';
    }
}


class Searcher {
    private ArrayList<Market> markets;
    private ArrayList<Item> items;


    Searcher(ArrayList<Market> markets, ArrayList<Item> items) {
        this.markets = markets;
        this.items = items;
    }


    double findMinPrice(String itemName) {
        Iterator iteratorMarkets = markets.iterator();
        Object obj = iteratorMarkets.next();
        if (obj instanceof Market) {
            Market mark = (Market) obj;
            Item item = mark.getItem(itemName);
            Item tmpItem;
            double tmpMinPrice = item.getPrice();
            while (iteratorMarkets.hasNext()) {
                Object obj1 = iteratorMarkets.next();
                if (obj1 instanceof Market) {
                    Iterator iteratorItemsIn = ((Market) obj1).getItems().iterator();
                    while (iteratorItemsIn.hasNext()) {
                        Object obj2 = iteratorItemsIn.next();
                        if (obj2 instanceof Item) {
                            tmpItem = (Item) obj2;
                            if (tmpItem.getName() == itemName && tmpItem.getPrice() < tmpMinPrice) {
                                tmpMinPrice = tmpItem.getPrice();
                            }
                        } else
                            throw new IllegalArgumentException("В списке не объект маркета");
                    }
                } else
                    throw new IllegalArgumentException("В списке не объект маркета");
            }
            return tmpMinPrice;
        } else
            throw new IllegalArgumentException("В списке не объект маркета");
    }


    ArrayList<Market> findMarkets(String itemName) {
        ArrayList<Market> marketsFound = new ArrayList<>();

        double minPrice = findMinPrice(itemName);

        Iterator<Market> iteratorMarkets = markets.iterator();
        while (iteratorMarkets.hasNext()) {
            Market tmp = iteratorMarkets.next();
            Iterator<Item> iteratorItems = tmp.getItems().iterator();
            if (tmp.gotItem(itemName) && iteratorItems.next().getPrice() == minPrice) {
                marketsFound.add(tmp);
            }
        }


        return marketsFound;

    }

    boolean marketPriceLower() {
        Iterator<Market> iteratorMarkets = markets.iterator();
        Iterator<Item> iteratorItems = items.iterator();
        Item tmpG;
        Item tmpGg;
        boolean isMarket = true;
        while (iteratorMarkets.hasNext()) {
            Iterator<Item> itemsOfMarket = iteratorMarkets.next().getItems().iterator();
            while (itemsOfMarket.hasNext()) {
                while (iteratorItems.hasNext()) {
                    tmpG = itemsOfMarket.next();
                    tmpGg = iteratorItems.next();
                    if (tmpG.getName() == tmpGg.getName()) {
                        if (tmpG.getPrice() >= tmpGg.getPrice()) {
                            isMarket = false;
                        }
                    }
                }
            }
            if (isMarket) {
                return true;
            }
        }
        return true;
    }
}

class Item implements Serializable {
    private String name;
    private double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    Item(Item otherItem) {
        this(otherItem.getName(), otherItem.getPrice());
    }


    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
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


