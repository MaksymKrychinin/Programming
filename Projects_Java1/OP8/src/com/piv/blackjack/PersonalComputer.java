package com.piv.blackjack;

public class PersonalComputer extends Gadgets{
    public PersonalComputer(String producer, String display, int modelId, int core, double frequency, int count) {
        super(producer, display, modelId, core, frequency, count);
        if (producer == "" | display == "") {
            throw new IllegalArgumentException("Пусто!");
        } else if (modelId <= 0 | core<=0 | frequency<=0 | count<0) {
            throw new IllegalArgumentException("Даные меньше 0");
        } else if (count==0){
            throw new IllegalArgumentException("Нету в наявности");
        }
    }
}
