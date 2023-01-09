package com.example.autoRent.Model.Factory;

import com.example.autoRent.Model.DAO.AdminDAO;
import com.example.autoRent.Model.DAO.UserDAO;
import com.example.autoRent.Model.DaoImpl.AdminDAOImpl;
import com.example.autoRent.Model.DaoImpl.UserDAOImpl;

public class UserDAOFactory {
    private static UserDAO dao = null;

    private UserDAOFactory() {
    }

    public static synchronized UserDAO getInstance() {
        if (dao == null) {
            dao = new UserDAOImpl();
        }
        return dao;
    }

}
