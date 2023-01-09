package com.example.autoRent.Model.Factory;

import com.example.autoRent.Model.DAO.AdminDAO;
import com.example.autoRent.Model.DaoImpl.AdminDAOImpl;

public class AdminDAOFactory {

    private static AdminDAO dao = null;

    private AdminDAOFactory() {
    }

    public static synchronized AdminDAO getInstance() {
        if (dao == null) {
            dao = new AdminDAOImpl();
        }
        return dao;

    }
}
