package lab11OP;

import java.util.Objects;

final class FoodProduct extends Goods {
    private final int id;

    public int getId() {
        return id;
    }

    public FoodProduct(String name, int price, int id) {
        super(name, price);
        this.id = id;
    }

    public FoodProduct() {
        this(null, 0, 0);
    }

    @Override
    public String toString() {
        return super.toString() + ", id=" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoodProduct that = (FoodProduct) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
