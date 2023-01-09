package lab11OP;

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
    public static int numPriceComp(Goods o1, Goods o2) {
        if (o1.getPrice() == o2.getPrice()) return
                0;
        if (o1.getPrice() == 0) return 1;
        if (o2.getPrice() == 0) return -1;
        return o1.getPrice() - (o2.getPrice());
    }

    public int nameFoodComp(Goods o1, Goods o2) {
        if (o1.getNameOfGood() == o2.getNameOfGood()) return 0;
        if (o1.getNameOfGood() == null) return 1;
        if (o2.getNameOfGood() == null) return -1;
        return o1.getNameOfGood().compareTo(o2.getNameOfGood());
    }
}


