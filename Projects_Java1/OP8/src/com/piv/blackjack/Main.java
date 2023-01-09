package com.piv.blackjack;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        try {
            Notebook MacBook = new Notebook("Apple", "OLED", 1, 8, 3.5, 100, 0);
            System.out.println(MacBook);
            Tablet IPad = new Tablet("Apple", "OLED", 2, true, 1);
            System.out.println(IPad);
            PersonalComputer IMac = new PersonalComputer("Apple", "OLED", 3, 8, 4.5, 13);
            System.out.println(IMac);
            Notebook Acer = new Notebook("Acer", "LCD", 4, 4, 4.3, 100, 0);
            System.out.println(Acer);
            Tablet IdeaTab = new Tablet("Apple", "LCD", 5, false, 2);
            System.out.println(IdeaTab);
            PersonalComputer AsusPc = new PersonalComputer("Apple", "LCD", 6, 4, 4.5, 1);
            System.out.println(AsusPc);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        Notebook Asus = new Notebook("Asus", "OLED", 1, 16, 4.5, 100, 0);
        Notebook AsusNew = new Notebook("Asus", "OLED", 1, 16, 4.5, 100, 0);
        System.out.println(Asus.equals(AsusNew));
    }
}

class Gadgets {
    protected String display;
    protected int modelId;
    protected String producer;
    protected int core;
    protected double frequency;
    protected boolean isArm;
    protected int count;


    Gadgets(String producer, String display, int modelId, int core, double frequency, int count) {
        this.display = display;
        this.modelId = modelId;
        this.core = core;
        this.frequency = frequency;
        this.producer = producer;
        this.count = count;
    }

    Gadgets(String producer, String display, int modelId, boolean isArm, int count) {
        this.producer = producer;
        this.display = display;
        this.modelId = modelId;
        this.isArm = isArm;
        this.count=count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gadgets gadgets = (Gadgets) o;
        return modelId == gadgets.modelId && core == gadgets.core && Double.compare(gadgets.frequency, frequency) == 0 && isArm == gadgets.isArm && count == gadgets.count && display.equals(gadgets.display) && producer.equals(gadgets.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(display, modelId, producer, core, frequency, isArm, count);
    }

    @Override
    public String toString() {
        return "Gadgets{" +
                "display='" + display + '\'' +
                ", modelId=" + modelId +
                ", producer='" + producer + '\'' +
                ", core=" + core +
                ", frequency=" + frequency +
                ", isArm=" + isArm +
                ", count=" + count +
                '}';
    }
}