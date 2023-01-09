package com.lab4EE.DAOimpl;

import com.lab4EE.Model.DB.DBConnection;
import com.lab4EE.Model.Entities.Item;
import com.lab4EE.Model.Entities.Market;
import com.lab4EE.Model.Entities.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServiceDAO implements com.lab4EE.DAO.ServiceDAO {
Service service;
    @Override
    public Service isMarketWithPriceLowerThanStock() {
        try (DBConnection dbConnection = new DBConnection()) {
            Connection connection = dbConnection.getConnection();
            String query = "SELECT m.marketName, i.itemName, f.itemPrice, i.recommendedPrice FROM inmarketprice f \n" +
                    "INNER JOIN item i ON i.iditem=f.idItem \n" +
                    "INNER JOIN market m ON m.idMarket=f.idMarket\n" +
                    "WHERE f.itemPrice<i.recommendedPrice";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            service = new Service();
            while (resultSet.next()){
                String marketName = resultSet.getString(1);
                String itemName = resultSet.getString(2);
                double itemPrice = resultSet.getDouble(3);
                double itemRecommendedPrice = resultSet.getDouble(4);
                Item item = new Item(itemName, itemPrice, itemRecommendedPrice);
                Market market = new Market(marketName, item);
                service.addMarketList(market);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }
}
