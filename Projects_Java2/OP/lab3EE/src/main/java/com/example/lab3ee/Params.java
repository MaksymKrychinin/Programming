package com.example.lab3ee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Params {
    private final Map<String, String> params;

    Params(Map<String,String[]> map) {
        params = new HashMap<>();
        List<String> keys = Keys.getNames();

        for (String keyName : keys) {
            params.put(keyName, map.get(keyName)[0]);
        }

    }

    public Map<String, String> getParams() {
        return params;
    }

    double[] toArray() {
        List<String> keys = Keys.getNames();
        double[] arr = new double[keys.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(params.get(keys.get(i)));
        }
        return arr;
    }

}

