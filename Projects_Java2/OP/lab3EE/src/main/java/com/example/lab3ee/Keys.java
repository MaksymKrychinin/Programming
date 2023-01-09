package com.example.lab3ee;

import java.util.ArrayList;
import java.util.List;

enum Keys {
    aFrom,//0
    bFrom,//1
    cFrom,//2
    dFrom,//3
    aTo,//4
    bTo,//5
    cTo,//6
    dTo,//7
    aStep,//8
    bStep,//9
    cStep,//10
    dStep;//11

    public static List<String> getNames(){
        List<String> names = new ArrayList<>();
         for(Keys key : Keys.values()){
             names.add(key.name());
         }
        return names;
    }
}
