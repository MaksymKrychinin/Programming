package lab6OP;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("arithmetic progress result: " + formula(90000000L));
        for (Map.Entry m : calc(90000000L).entrySet()) {
            System.out.println("th count: " + m.getKey() + "," + " time: " + m.getValue() + "ns;");
        }
    }

    private static HashMap<Integer, Long> calc(long N) {
        HashMap<Integer, Long> res = new HashMap<>();
        int[] threadsCount = {1, 2, 4, 8, 16, 32};

        long start;
        for (int thread : threadsCount) {
            start = System.nanoTime();
            calcProgress(N, thread);
            res.put(thread, System.nanoTime() - start);
        }
        return res;
    }

    private static void calcProgress(long n, int threadsCount) {
        long max = 0;
        long min;
        long m = n / threadsCount;
        long last = n / threadsCount + n % threadsCount;
        MyThread thread;
        for (int i = 0; i < threadsCount; i++) {
            min = max + 1;
            max = (min - 1) +
                    (i == threadsCount - 1 ? last : m);
            thread = new MyThread(24, min, max);
            thread.start();
        }
    }

    private static long formula(long N) {
        return ((46 + 24 * (N - 1)) / 2) * N;
    }

}
