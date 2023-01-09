package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class signIn {
    String role;

    public String roleOfUser(String login, String password) {
        try (DBConnection db = new DBConnection()) {
            String query = "SELECT role FROM sinoptik.users where login = ? and password = ?;";
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                role=result.getString("role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

}