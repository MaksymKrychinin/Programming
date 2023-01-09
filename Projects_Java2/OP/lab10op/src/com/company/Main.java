package com.company;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Calculator foo1 = (a, b, c, d) -> Math.cbrt(Math.tan(a)) / (1 + (Math.sinh(b) / Math.log(d + c)));
        Calculator foo2 = (a, b, c, d) -> Math.pow(Math.tan(a), 1 / c) / (1 + (Math.sinh(b) / Math.log(d + c)));
        Calculator foo3 = (a, b, c, d) -> Math.log(Math.abs((c / a) * (Math.sqrt((Math.tanh(Math.abs(b)) * c) /
                ((Math.log(d)) / (Math.log(Math.sqrt(c)))))))) / (Math.log(a));
        new Calculation().calculation(foo1, 3.56, 1.02, 3, 2.43);
        new Calculation().calculation(foo2, 1.234, -3.12, 5.45, 2);
        new Calculation().calculation(foo3, 2.54, -1.34, 1.05, 0.78);

        List<Goods> goods = new ArrayList<>();
        goods.add(new Goods("bicycle", 100));
        goods.add(new FoodProduct("banana", 300, 4));
        goods.add(new FoodProduct());
        goods.forEach(System.out::println);
    }

}
