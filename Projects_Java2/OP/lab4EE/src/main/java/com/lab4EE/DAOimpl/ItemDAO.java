package com.lab4EE.DAOimpl;

import com.lab4EE.DAO.ItemDao;
import com.lab4EE.Model.DB.DBConnection;
import com.lab4EE.Model.Entities.Item;

import java.sql.*;

public class ItemDAO implements ItemDao {
    Item item;
    @Override
    public Item minItemPrice(String name) {
        try (DBConnection dbConnection = new DBConnection()) {
            Connection connection = dbConnection.getConnection();
            String query = "SELECT MIN(f.itemPrice)\n" +
                    "FROM inmarketprice f\n" +
                    "INNER JOIN item i ON i.iditem=f.idItem \n" +
                    "WHERE i.itemName=?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet priceOfFirst = statement.executeQuery();
            while (priceOfFirst.next()) {
                double price = priceOfFirst.getDouble(1);
                 item = new Item(name, price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }



}
