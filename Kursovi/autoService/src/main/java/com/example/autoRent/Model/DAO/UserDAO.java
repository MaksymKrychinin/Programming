package com.example.autoRent.Model.DAO;

import com.example.autoRent.Model.Entity.Bill;
import com.example.autoRent.Model.Entity.Car;
import com.example.autoRent.Model.Entity.User;

import java.util.List;

public interface UserDAO {
    User signIn(String email, String password);
    User register(User user);
}
