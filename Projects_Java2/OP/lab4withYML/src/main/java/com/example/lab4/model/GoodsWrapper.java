package com.example.lab4.model;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class GoodsWrapper {

    private TreeSet<Good> goods;

    public TreeSet<Good> getGoods() {
        return goods;
    }

    public void setGoods(TreeSet<Good> goods) {
        this.goods = goods;
    }

    public Map<String, Good> getGoodsMap() {
        Map <String, Good> goodsMap = new HashMap<>();
        for (Good good: goods) {
            goodsMap.put(good.getName(), good);
        }

        return goodsMap;
    }

    public Good getGoodByName(String goodName) {
        for (Good good: goods) {
            if (good.getName().equals(goodName)) {
                return good;
            }
        }

        throw new IllegalArgumentException("There is no good with name " + goodName);
    }
}
