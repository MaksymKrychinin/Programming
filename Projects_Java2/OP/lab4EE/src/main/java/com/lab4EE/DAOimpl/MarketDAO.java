package com.lab4EE.DAOimpl;

import com.lab4EE.Model.DB.DBConnection;
import com.lab4EE.Model.Entities.Item;
import com.lab4EE.Model.Entities.Market;
import com.lab4EE.Model.Entities.Service;

import java.sql.*;

public class MarketDAO implements com.lab4EE.DAO.MarketDAO {
    @Override
    public Service findMarketsMinItemPrice(String name) {
        Service service = new Service();
        try (DBConnection dbConnection = new DBConnection()) {
            Connection connection = dbConnection.getConnection();
            String query = "SELECT m.marketName, i.itemName, f.itemPrice\n" +
                    "FROM inmarketprice f\n" +
                    "INNER JOIN item i ON i.iditem=f.idItem inner join market m ON m.idMarket=f.idMarket\n" +
                    "WHERE itemName=? and itemPrice=(SELECT MIN(itemPrice) FROM inmarketprice " +
                    "INNER JOIN item i ON i.idItem=inmarketprice.idItem where itemName=?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,name);
            ResultSet minItemResultSet = preparedStatement.executeQuery();
            while (minItemResultSet.next()) {
                String marketName = minItemResultSet.getString(1);
                String itemName = minItemResultSet.getString(2);
                double price = minItemResultSet.getDouble(3);
                Item item = new Item(itemName, price);
                Market market = new Market(marketName, item);
                service.addMarketList(market);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }


}
