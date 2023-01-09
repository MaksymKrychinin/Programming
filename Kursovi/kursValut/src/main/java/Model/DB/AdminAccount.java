package Model.DB;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminAccount {

    public boolean admin(String login, String password) {
        try (DataBaseConnection dataBaseConnection = new DataBaseConnection()) {
            String query = "SELECT * FROM exchange.admin where login = ? and password = ?;";
            PreparedStatement ps = dataBaseConnection.getConnection().prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
