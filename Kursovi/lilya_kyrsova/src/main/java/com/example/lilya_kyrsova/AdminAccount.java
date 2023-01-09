package com.example.lilya_kyrsova;

import DB.DB;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminAccount {
    boolean isAdmin = false;
    String token;

    boolean isAdmin(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try (DB db = new DB()) {
            String query = "SELECT token FROM exchange.admin where login = ? and password = ?;";
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isAdmin=true;
                token = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdmin;
    }

}
