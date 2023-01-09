package com.OP10Maven;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemsSearcher extends DBConnection implements ItemsDao {
    private double minPrice;
    private boolean isMarket;

    @Override
    public double minItemPrice(String Name) {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM items WHERE Name ='" + Name + "' ORDER BY Price limit 1";
            ResultSet priceOfFirst = statement.executeQuery(query);
            while (priceOfFirst.next()) {
                minPrice = priceOfFirst.getDouble("Price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return minPrice;
    }

    @Override
    public String findMarketMinItemPrice(String Name) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM items WHERE name='" + Name + "' " +
                    "and Price = (SELECT MIN(Price) FROM items where Name = '" + Name + "') ";
            ResultSet minItemResultSet = statement.executeQuery(query);
            while (minItemResultSet.next()) {
                stringBuilder.append("[Market:"
                        + minItemResultSet.getString("Market")
                        + "; Item:" + minItemResultSet.getString("Name")
                        + "; Price:" + minItemResultSet.getDouble("Price")
                        + "] " + '\n');
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    @Override
    public boolean isMarketWithPriceLowerThanStock() {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM items WHERE Price<StockPrice";
            if (statement.executeQuery(query).next()) {
                isMarket = true;
            } else isMarket = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isMarket;
    }
}
