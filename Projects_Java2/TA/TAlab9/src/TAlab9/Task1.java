package TAlab9;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public List<Thing> findMaxPrice(List<Thing> ourThings, int maxCapacity) {
        int answer;
        List<Thing> answ = new ArrayList<>();
        int prev;
        int byFormula;
        int[][] search = new int[ourThings.size() + 1][maxCapacity + 1];

        for (int i = 0; i <= ourThings.size(); i++) {
            for (int j = 0; j <= maxCapacity; j++) {
                if (i == 0 || j == 0) {
                    search[i][j] = 0;
                } else {
                    if (ourThings.get(i - 1).getWeight() > j) {
                        search[i][j] = search[i - 1][j];
                    } else {
                        prev = search[i - 1][j];
                        byFormula = ourThings.get(i - 1).getPrice() + search[i - 1][j - ourThings.get(i - 1).getWeight()];
                        search[i][j] = Math.max(prev, byFormula);
                        if (byFormula > prev) {
                            answ.add(ourThings.get(i));
                        }
                    }

                }
            }
        }
        return answ;
    }
}
