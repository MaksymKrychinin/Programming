package DB;

import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserCommands implements DAO {
    private Connection connection = null;
    private String query;
    private boolean noError = true;
    private boolean userAvaliable = false;
    private String name;
    private String date;

    @Override
    public boolean add(String PIB, String date, String password, String login) {
        try (DBConnection dbConnection = new DBConnection();
             Statement statement = dbConnection.getConnection().createStatement()) {
            query = "INSERT INTO users.users(PIB, dateBD, login, password) " +
                    "VALUES ('" + PIB + "', '" + date + "', '" + login + "', '" + md5(password) + "');";
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
            noError=false;
        }
        return noError;
    }

    @Override
    public boolean currentUser(String login, String password) {
        try (DBConnection dbConnection = new DBConnection();
             Statement statement = dbConnection.getConnection().createStatement()) {
            query = "SELECT * FROM Users where password='" + md5(password) + "' and login='" + login + "';";
            ResultSet hasAccount = statement.executeQuery(query);
            userAvaliable = hasAccount.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userAvaliable;
    }

    @Override
    public String name(String login) {
        try (DBConnection dbConnection = new DBConnection();
             Statement statement = dbConnection.getConnection().createStatement()) {
            query = "SELECT PIB FROM users where login='" + login + "';";
            ResultSet nameResult = statement.executeQuery(query);
            while (nameResult.next()) {
                name = nameResult.getString("PIB");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public String date(String login) {
        try (DBConnection dbConnection = new DBConnection();
             Statement statement = dbConnection.getConnection().createStatement()) {
            query = "SELECT dateBD FROM users where login='" + login + "';";
            ResultSet nameResult = statement.executeQuery(query);
            while (nameResult.next()) {
                date = nameResult.getString("dateBD");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public boolean editProfile(String login, String PIB, String date, String currentPassword, String newPassword) {
        try (DBConnection dbConnection = new DBConnection();
             Statement statement = dbConnection.getConnection().createStatement()) {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    String md5(String password) throws ClassNotFoundException {
        return DigestUtils.md5Hex(password).toUpperCase();
    }
}
