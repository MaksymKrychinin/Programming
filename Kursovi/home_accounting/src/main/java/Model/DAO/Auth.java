package Model.DAO;

import Model.DB.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Auth {
    private int idUser=0;
    private boolean status=false;

    public int login(String login, String password) {
        try (DBConnection db = new DBConnection()) {
            String query = "select idUser from home_accounting.user where login = ? and password = ?;";
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                idUser = result.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idUser;
    }

    public boolean register(String login, String password) {
        try (DBConnection db = new DBConnection()) {
            String query = "insert into home_accounting.user (login, password) VALUES (?,?);";
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            if (preparedStatement.executeUpdate()==1){
                status=true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}