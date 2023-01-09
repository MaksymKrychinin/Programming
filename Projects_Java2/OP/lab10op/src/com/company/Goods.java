package com.company;

import java.util.Objects;


class Goods {
    private final String nameOfGood;
    private final int price;

    public String getNameOfGood() {
        return this.nameOfGood;
    }

    public int getPrice() {
        return this.price;
    }

    public Goods(String nameOfGood, int price) {
        this.nameOfGood = nameOfGood;
        this.price = price;
    }

    @Override
    public String toString() {
        return "nameOfGood = " + nameOfGood + ", price=" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return price == goods.price && Objects.equals(nameOfGood, goods.nameOfGood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfGood, price);
    }
}


