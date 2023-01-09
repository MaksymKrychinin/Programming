package com.example.autoRent.Model.Factory;

import com.example.autoRent.Model.DAO.CarDAO;
import com.example.autoRent.Model.DaoImpl.CarDAOImpl;

public class CarDAOFactory {
    private static CarDAO dao = null;

    private CarDAOFactory() {
    }

    public static synchronized CarDAO getInstance() {
        if (dao == null) {
            dao = new CarDAOImpl();
        }
        return dao;
    }

}
