package Model.DAO;

import Model.DB.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Auth {
    public int getUserPermission() {
        return userPermission;
    }

    public int getIdUser() {
        return idUser;
    }

    private int userPermission=-1;
    private int idUser =-1;

    public void login(String login, String password) {
        try (DBConnection db = new DBConnection()) {
            String query = "select iduser, permission from vacancy.user where login = ? and password = ?;";
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                idUser = result.getInt(1);
                userPermission = result.getInt(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void register(String login, String password, int permission) {
        try (DBConnection db = new DBConnection()) {
            String query = "insert into vacancy.user (login, password, permission) VALUES (?,?,?);";
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, permission);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}