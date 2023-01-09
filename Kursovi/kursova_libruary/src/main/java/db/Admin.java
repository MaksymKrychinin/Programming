package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
    boolean admin = false;

    public boolean isAdmin(String login, String password) {
        try (DBConnection db = new DBConnection()) {
            String query = "SELECT COUNT(*) FROM libruary.admin where login = ? and password = ?;";
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1)==1){
                admin=true;}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

}