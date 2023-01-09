package lab6OP;

public class MyThread extends Thread {
    long x;
    long min;
    long max;
    long result;

    public MyThread(long x, long min, long max) {
        this.x = x;
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        long res = 0;
        for (long i = min; i <= max; i++) {
            res += x * i;
        }
        result = res;
    }
}

