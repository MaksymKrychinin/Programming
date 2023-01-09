package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CurrencyDB {

    public static void renameCurrency(String name, String newName) {
        String query = "UPDATE currency SET currencyName = ? where currencyName = ?;";
        try (DB db = new DB()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addNewCurrency(String name) {
        String query = "INSERT currency(currencyName) VALUES (?);";
        try (DB db = new DB()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteCurrency(String name) {
        String query = "DELETE FROM currency WHERE currency.currencyName LIKE ?;";
        try (DB db = new DB()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
