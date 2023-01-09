package lab11OP;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<String, Integer, Goods> good = Goods::new;
        List<Goods> goods = new ArrayList<>();
        Goods g = new FoodProduct("Banana", 30, 4);
        goods.add(new Goods("bicycle ", 800));
        goods.add(new FoodProduct("Apple ", 80, 5));
        goods.add(g);
        goods.add(new FoodProduct());
        goods.forEach(System.out::println);
        goods.sort(Goods::numPriceComp);
        goods.forEach(System.out::println);
        goods.sort(g::nameFoodComp);
        goods.forEach(System.out::println);
    }
}




