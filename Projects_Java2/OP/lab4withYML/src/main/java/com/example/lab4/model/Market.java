package com.example.lab4.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Market implements Comparable<Market>{

    private String marketName;

    private TreeSet<Good> goods;

    public String getMarketName() {
        return marketName;
    }

    public Map<String, Good> getGoodsMap(){
        Map<String, Good> map = new HashMap<>();
        if(goods==null){
            throw new NullPointerException("There is no products in " + getMarketName());
        }
        for(Good good : goods){
            map.put(good.getName(),good);
        }
        return map;
    }


    public void doDicsount(int percent) {
        if(goods==null){
            throw new NullPointerException("There is no products in " + getMarketName());
        }
        Iterator<Good> iterator = goods.iterator();
        while (iterator.hasNext()) {
            Good tmp = iterator.next();
            double tmp1 = tmp.getPrice();
            tmp.setPrice((tmp1 * (100 - percent)) / 100);

        }
    }

    public boolean setPriceAtGood(double price, String name) {
        Iterator<Good> iterator = goods.iterator();
        for(Good good : goods){
            if(good.getName().equals(name)){
                good.setPrice(price);
                return true;
            }
        }
        throw new NullPointerException("There is no " + name + " in " + marketName);
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public TreeSet<Good> getGoods() {
        return goods;
    }

    public void setGoods(TreeSet<Good> goods) {
        this.goods = goods;
    }


    @Override
    public int compareTo(Market o) {
        return marketName.compareTo(o.getMarketName());
    }
}
