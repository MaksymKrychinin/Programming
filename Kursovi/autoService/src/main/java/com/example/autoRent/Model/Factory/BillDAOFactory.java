package com.example.autoRent.Model.Factory;

import com.example.autoRent.Model.DAO.BillDAO;
import com.example.autoRent.Model.DaoImpl.BillDAOImpl;

public class BillDAOFactory {
    private static BillDAO dao = null;

    private BillDAOFactory() {
    }

    public static synchronized BillDAO getInstance() {
        if (dao == null) {
            dao = new BillDAOImpl();
        }
        return dao;
    }

}
