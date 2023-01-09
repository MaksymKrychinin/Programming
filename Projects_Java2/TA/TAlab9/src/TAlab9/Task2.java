package TAlab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public List<Thing> task2GA(List<Thing> things, int backpackSize) {
        List<Thing> inBackpack = new ArrayList<>();
        Collections.sort(things);
        for (Thing thing : things) {
            if (thing.weight <= backpackSize) {
                inBackpack.add(thing);
                backpackSize -= thing.weight;
            }
        }
        return inBackpack;
    }
}
