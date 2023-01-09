package com.example.balancesystemforbaccarat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BetClass {
    static BetClass betClass;

    private BetClass() {
    }

    public static synchronized BetClass getInstance() {
        if (betClass == null) {
            betClass = new BetClass();
        }
        return betClass;
    }

    List<User> list = new ArrayList<>();
}
