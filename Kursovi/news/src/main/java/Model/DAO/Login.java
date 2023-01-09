package Model.DAO;

import Model.DB.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    int userId = 0;
    int admin = 0;

    public int getUserId() {
        return userId;
    }

    public int getAdmin() {
        return admin;
    }

    public void login(String login, String password) {
        try (DBConnection db = new DBConnection()) {
            String query = "SELECT idusers, admin FROM news.users where login = ? and password = ?;";
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                userId = result.getInt(1);
                admin = result.getInt(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registration(String login, String password) {
        try (DBConnection db = new DBConnection()) {
            String query = "insert into news.users (login, password) VALUES (?,?);";
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}