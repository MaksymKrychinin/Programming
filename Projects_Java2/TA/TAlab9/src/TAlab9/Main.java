package TAlab9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thing> things= new ArrayList<>();
        things.add(new Thing(1, 6));
        things.add(new Thing(2, 8));
        things.add(new Thing(3, 3));
        things.add(new Thing(5, 9));
        things.add(new Thing(7, 5));
        things.add(new Thing(10, 12));
        things.add(new Thing(3, 4));
        things.add(new Thing(4, 10));
        things.add(new Thing(15, 1));
        things.add(new Thing(6, 3));
        int backpackSize = 20;
        System.out.println(new Task2().task2GA(things, backpackSize).size());
        List<Thing> crossing = new Task3().crossing(new Task1().findMaxPrice(things, backpackSize), new Task2().task2GA(things, backpackSize));
/*        for (Thing thing : crossing) {
            System.out.println(thing);
        }*/
    }
}
