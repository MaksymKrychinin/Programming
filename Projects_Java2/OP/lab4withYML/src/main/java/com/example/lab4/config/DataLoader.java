package com.example.lab4.config;

import com.example.lab4.model.Good;
import com.example.lab4.model.GoodsWrapper;
import com.example.lab4.model.MarketsWrapper;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;

public class DataLoader{


    private MarketsWrapper markets;
    private GoodsWrapper goods;

    private static volatile DataLoader instance;

    private DataLoader() throws IOException {
        TreeSet<Good> treeSet = new TreeSet<>();

        Constructor marketConstructor = new Constructor(MarketsWrapper.class);
        Yaml marketYaml = new Yaml(marketConstructor);
        this.markets = marketYaml.load(getClass().getClassLoader().getResourceAsStream(marketsFileName));


    }

    public static DataLoader getInstance() throws IOException{
        DataLoader localInstance = instance;
        if (localInstance == null) {
            synchronized (DataLoader.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DataLoader();
                }
            }
        }
        return localInstance;
    }

    public GoodsWrapper getGoods() {
        return this.goods;
    }

    public MarketsWrapper getMarkets() { return this.markets;}
}
