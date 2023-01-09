package TAlab9;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public List<Thing> crossing(List<Thing> inBackpack1, List<Thing> inBackpack2) {
        List<Thing> crossing = new ArrayList<>();
        for (Thing thing1 : inBackpack1) {
            for (Thing thing2 : inBackpack2) {
                if(thing1.equals(thing2)) {
                    crossing.add(thing2);
                    break;
                }
            }
        }
        return crossing;
    }
}
