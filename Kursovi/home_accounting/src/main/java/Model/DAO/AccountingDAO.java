package Model.DAO;

import Model.DB.DBConnection;
import Model.Entity.Buy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountingDAO {
    public List<Buy> buyListOnCategory(int idUser, String category) {
        List<Buy> buyList = new ArrayList<>();
        String query = "SELECT a.idBuy, a.buyName, d.dateName, a.cost FROM home_accounting.accounting a\n" +
                "Inner join date d on a.idDate=d.idDate\n" +
                "inner join category c on a.idCategory=c.idCategory\n" +
                "where a.idUser = ? and c.categoryName=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idUser);
            preparedStatement.setString(2, category);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBuy = resultSet.getInt(1);
                String buyName = resultSet.getString(2);
                Date date = resultSet.getDate(3);
                double cost = resultSet.getDouble(4);
                Buy buy = new Buy(idBuy, buyName, category, date, cost);
                buyList.add(buy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buyList;
    }

    public List<Buy> buyListBetweenDate(int idUser, Date date1, Date date2) {
        List<Buy> buyList = new ArrayList<>();
        String query = "SELECT a.idBuy, a.buyName, c.categoryName, d.dateName, a.cost FROM home_accounting.accounting a\n" +
                "Inner join date d on a.idDate=d.idDate\n" +
                "inner join category c on a.idCategory=c.idCategory\n" +
                "where a.idUser = ? and d.dateName between ? and ?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idUser);
            preparedStatement.setDate(2, date1);
            preparedStatement.setDate(3, date2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBuy = resultSet.getInt(1);
                String buyName = resultSet.getString(2);
                String category = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                double cost = resultSet.getDouble(5);
                Buy buy = new Buy(idBuy, buyName, category, date, cost);
                buyList.add(buy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buyList;
    }

    public void addBuy(int idUser, String buyName, String buyCategory, Date buyDate, double buyCost) {
        String query1 = "INSERT IGNORE INTO home_accounting.category(categoryName) VALUES (?);";
        String query2 = "INSERT IGNORE INTO home_accounting.date(dateName) VALUES (?);";
        String query3 = "INSERT IGNORE INTO accounting(buyName, idCategory, idDate, cost, iduser) \n" +
                "VALUES(?, (SELECT idCategory FROM home_accounting.category where categoryName=?),\n" +
                "(SELECT idDate FROM home_accounting.date where dateName=?), ?, ?)";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setString(1, buyCategory);
            preparedStatement1.executeUpdate();
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setDate(1, buyDate);
            preparedStatement2.executeUpdate();
            PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
            preparedStatement3.setString(1, buyName);
            preparedStatement3.setString(2, buyCategory);
            preparedStatement3.setDate(3, buyDate);
            preparedStatement3.setDouble(4, buyCost);
            preparedStatement3.setInt(5, idUser);
            preparedStatement3.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editBuy(int idBuy, int idUser, String buyName, String buyCategory, Date buyDate, double buyCost) {
        String query1 = "INSERT IGNORE INTO home_accounting.category(categoryName) VALUES (?);";
        String query2 = "INSERT IGNORE INTO home_accounting.date(dateName) VALUES (?);";
        String query = "UPDATE home_accounting.accounting SET buyName=?, \n" +
                "idCategory=(SELECT idCategory FROM home_accounting.category where categoryName=?),\n" +
                "idDate =(SELECT idDate FROM home_accounting.date where dateName=?), \n" +
                "cost = ? where idBuy=? and idUser=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setString(1, buyCategory);
            preparedStatement1.executeUpdate();
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setDate(1, buyDate);
            preparedStatement2.executeUpdate();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,buyName);
            preparedStatement.setString(2, buyCategory);
            preparedStatement.setDate(3, buyDate);
            preparedStatement.setDouble(4, buyCost);
            preparedStatement.setInt(5,idBuy);
            preparedStatement.setInt(6,idUser);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBuy(int idBuy, int idUser) {
        String query = "DELETE FROM home_accounting.accounting where idBuy=? and idUser =?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idBuy);
            preparedStatement.setInt(2, idUser);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
