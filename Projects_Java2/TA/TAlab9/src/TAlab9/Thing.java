package TAlab9;

import java.util.Objects;

public class Thing implements Comparable<Thing> {
    public int weight;
    public int price;
    public Thing(int weight, int price){
        this.weight=weight;
        this.price=price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "weight=" + weight +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Thing o) {
        return this.weight - o.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return weight == thing.weight && price == thing.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, price);
    }
}
