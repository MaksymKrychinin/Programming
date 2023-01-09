package OP10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Item IphoneComfy = new Item("Iphone", 1200, 1199);
        Item XiaomiComfy = new Item("Xiaomi", 500, 320);
        Item HuaweiComfy = new Item("Huawei", 120, 300);
        ArrayList<Item> allItemsComfy = new ArrayList<Item>();
        allItemsComfy.add(IphoneComfy);
        allItemsComfy.add(XiaomiComfy);
        allItemsComfy.add(HuaweiComfy);
        Markets Comfy = new Markets("Comfy", allItemsComfy);

        Item IphoneRozetka = new Item("Iphone", 1200, 3200);
        Item XiaomiRozetka = new Item("Xiaomi", 500, 200);
        Item HuaweiRozetka = new Item("Huawei", 120, 280);
        ArrayList<Item> allItemsRozetka = new ArrayList<Item>();
        allItemsRozetka.add(IphoneComfy);
        allItemsRozetka.add(XiaomiComfy);
        allItemsRozetka.add(HuaweiComfy);
        Markets Rozetka = new Markets("Rozetka", allItemsRozetka);

        Item IphoneAliexpress = new Item("Iphone", 1200, 1199);
        Item XiaomiAliexpress = new Item("Xiaomi", 500, 499);
        Item HuaweiAliexpress = new Item("Huawei", 120, 119);
        ArrayList<Item> allItemsAliexpress = new ArrayList<Item>();
        allItemsAliexpress.add(IphoneComfy);
        allItemsAliexpress.add(XiaomiComfy);
        allItemsAliexpress.add(HuaweiComfy);
        Markets Aliexpress = new Markets("Aliexpress", allItemsAliexpress);


        //Задача:


        //2) скласти список магазинів, в яких заданий товар можна купити по мінімальній ціні
        // c) типізований цикл «for-each».

        //3) Визначити, чи є магазин, усі товари якого можна купити по цінам, дешевшим
        // ніж рекомендована ціна виробника
        // а) нетипізований ітератор;
    }
}

class ItemSearchInMarket {
    // Сервіс пошуку товарів (список інтернет-магазинів)
    private String marketList;


    ItemSearchInMarket(String marketList) {
        this.marketList = marketList;
    }

}

//Товар (назва товару, рекомендована ціна виробника)
class Item {
    private String itemName;
    private double itemCost;
    private double recommendedCost;

    Item(String itemName, double recommendedCost, double itemCost) {
        this.itemName = itemName;
        this.recommendedCost = recommendedCost;
        this.itemCost = itemCost;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemCost() {
        return itemCost;
    }

    public double getRecommendedCost() {
        return recommendedCost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemCost=" + itemCost +
                ", recommendedCost=" + recommendedCost +
                '}';
    }
}

//Інтернет-магазин (назва магазина, список товарів та цін на них в цьому магазині)
class Markets {
    private String marketName;
    ArrayList<Item> itemsAllInfo;

    public String getMarketName() {
        return marketName;
    }

    public List getItemsAllInfo() {
        return itemsAllInfo;
    }



    Markets(String marketName, ArrayList itemsAllInfo) {
        this.marketName = marketName;
        this.itemsAllInfo = itemsAllInfo;
    }

}
//1) знайти мінімальну ціну на заданий товар
// b) типізований ітератор;

