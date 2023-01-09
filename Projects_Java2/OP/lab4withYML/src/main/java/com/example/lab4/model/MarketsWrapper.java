package com.example.lab4.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MarketsWrapper {

    private TreeSet<Market> markets;


    public TreeSet<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(TreeSet<Market> markets) {
        this.markets = markets;
    }

    public Market getMarketByName(String marketName) {
        for (Market market: markets) {
            if (market.getMarketName().equals(marketName)) {
                return market;
            }
        }

        throw new IllegalArgumentException("There is no market with name " + marketName);
    }

    public Map<String, Double> getGoodValuePerMarket(String goodName) {
        Map<String, Double> result = new HashMap<>();

        for (Market market: markets) {
            for (Good good: market.getGoods()) {
                if (good.getName().equals(goodName)) {
                    result.put(market.getMarketName(), good.getPrice());
                    break;
                }
            }
        }
        return result;
    }

    public Map<String, Double> findLowestGoodValuePerMarket(String goodName) {

        Map<String, Double> sortedMap = getGoodValuePerMarket(goodName).entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));

        Map<String, Double> result = new HashMap<>();
        Double lowest = null;
        for (Map.Entry<String, Double> entry: sortedMap.entrySet()) {
            if (lowest==null) {
                lowest = entry.getValue();
            }
            if(lowest.equals(entry.getValue())){
                result.put(entry.getKey(), entry.getValue());
            }else {
                return result;
            }
        }
        return result;
    }
}
