package com.lab4EE.DAO;

import com.lab4EE.Model.Entities.Service;

public interface MarketDAO {
    Service findMarketsMinItemPrice(String Name);

}
