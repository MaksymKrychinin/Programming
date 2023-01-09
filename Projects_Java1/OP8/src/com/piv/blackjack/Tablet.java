package com.piv.blackjack;

public class Tablet extends Gadgets {

    public Tablet(String producer, String display, int modelId, boolean isArm, int count) {
        super(producer, display, modelId, isArm, count);
        if (producer == "" | display == "") {
            throw new IllegalArgumentException("Пусто!");
        } else if (modelId <= 0 | count<0) {
            throw new IllegalArgumentException("Даные меньше 0");
        } else if (count==0){
            throw new IllegalArgumentException("Нету в наявности");
        }
    }

}

