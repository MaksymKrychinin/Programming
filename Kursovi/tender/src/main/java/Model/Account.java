package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Account {
    private int idUser=0;
    private boolean registered;

    public int signIn(String login, String password) {
        try (DBConnection db = new DBConnection()) {
            String query = "SELECT idusers FROM tender.users where login=? and password=?;";
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

    public boolean register(String username, String login, String password) {
        registered = false;
        try (DBConnection db = new DBConnection()) {
            String query = "INSERT INTO tender.users (username, login, password) VALUES (?,?,?);";
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, password);
            if (preparedStatement.executeUpdate()==1){
                registered=true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return registered;
    }

}