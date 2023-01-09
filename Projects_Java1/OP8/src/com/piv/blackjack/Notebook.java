package com.piv.blackjack;

import java.util.Objects;

public class Notebook extends Gadgets {
    int batteryTime;

    public void setBatteryTime(int batteryTime) {
        this.batteryTime = batteryTime;
    }

    public Notebook(String producer, String display, int modelId, int core, double frequency, int count, int batteryTime) {
        super(producer, display, modelId, core, frequency, count);
        if (producer == "" | display == "") {
            throw new IllegalArgumentException("Пусто!");
        } else if (modelId <= 0 | core <= 0 | frequency <= 0 | count < 0) {
            throw new IllegalArgumentException("Даные меньше 0");
        } else if (count == 0) {
            throw new IllegalArgumentException("Нету в наявности");
        }//
        this.batteryTime=batteryTime;
    }

    @Override
    public String toString() {
        return "Notebook{" + super.toString()+
                "batteryTime=" + batteryTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Notebook notebook = (Notebook) o;
        return batteryTime == notebook.batteryTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batteryTime);
    }
}