package DB;

import Entity.Currency;
import Entity.ExchangeRate;

import java.sql.*;
import java.time.LocalDate;

public class ExchangeDB {
    public static void addRate(String name, Date date, double sellRate, double buyRate) {
        String query = "INSERT INTO exchange.rate (`currency`, `data`, `sellRate`, `buyRate`) " +
                "VALUES ((SELECT idCurrency FROM exchange.currency where currencyName LIKE ?)," +
                " ?, ?, ?);";
        try (DB db = new DB()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, date);
            preparedStatement.setDouble(3, sellRate);
            preparedStatement.setDouble(4, buyRate);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ExchangeRate tableCurrecyOfDate(String name, Date dateFrom, Date dateTo) {
        ExchangeRate exchangeDB = new ExchangeRate();
        String query = "SELECT e.data, e.sellRate, e.buyRate FROM exchange.rate e\n" +
                "INNER JOIN currency c ON c.idCurrency=e.currency\n" +
                "WHERE c.currencyName=? and e.data between ? and ?;";
        try (DB db = new DB()) {
            Connection connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setDate(2, dateFrom);
            statement.setDate(3, dateTo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Date dateToReturn = resultSet.getDate(1);
                double sellRate = resultSet.getDouble(2);
                double buyRate = resultSet.getDouble(3);
                Currency currency = new Currency(name, sellRate, buyRate, dateToReturn);
                exchangeDB.addToList(currency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exchangeDB;
    }

    public static ExchangeRate tableAllRateToday() {
        ExchangeRate exchangeDB = new ExchangeRate();
        Date date = Date.valueOf(LocalDate.now());
        String query = "SELECT c.currencyName, e.sellRate, e.buyRate FROM exchange.rate e\n" +
                "INNER JOIN currency c ON c.idCurrency=e.currency\n" +
                "WHERE e.data = ?;";
        try (DB db = new DB()) {
            Connection connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, date);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                double sellRate = resultSet.getDouble(2);
                double buyRate = resultSet.getDouble(3);
                Currency currency = new Currency(name, sellRate, buyRate, date);
                exchangeDB.addToList(currency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exchangeDB;
    }
}
