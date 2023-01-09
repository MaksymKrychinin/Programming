package OP10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        ArrayList<Item> itemsComfy = new ArrayList<>();
        Item item1c = new Item("Iphone", 1200);
        Item item2c = new Item("Xiaomi", 600);
        Item item3c = new Item("Huawei", 720);
        itemsComfy.add(item1c);
        itemsComfy.add(item2c);
        itemsComfy.add(item3c);

        ArrayList<Item> itemsRozetka = new ArrayList<>();
        Item item1r = new Item("Iphone", 1201);
        Item item2r = new Item("Xiaomi", 601);
        Item item3r = new Item("Huawei", 721);
        itemsComfy.add(item1r);
        itemsComfy.add(item2r);
        itemsComfy.add(item3r);

        ArrayList<Market> markets = new ArrayList<>();
        Market Comfy = new Market("Comfy", itemsComfy);
        Market Rozetka = new Market("Rozetka", itemsRozetka);
        markets.add(Comfy);
        markets.add(Rozetka);

        Searcher searcher = new Searcher(markets);
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
        this.items = items;
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

    Searcher(ArrayList<Market> markets) {
        this.markets = markets;
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
        Iterator<Item> iteratorItems = iteratorMarkets.next().getItems().iterator();
        Item tmpG;
        Item tmpGg;
        boolean isMarket = true;
        while (iteratorMarkets.hasNext()) {
            Iterator<Item> itemsOfMarket = iteratorMarkets.next().getItems().iterator();
            while (itemsOfMarket.hasNext()) {
                while (iteratorItems.hasNext()) {
                    tmpG = itemsOfMarket.next();
                    tmpGg = iteratorItems.next();
                    if (tmpG.getName().equals(tmpGg.getName())) {
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


