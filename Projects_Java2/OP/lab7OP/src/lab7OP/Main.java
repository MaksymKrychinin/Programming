package lab7OP;

import java.io.File;
import java.util.Map;
import java.util.concurrent.*;

import static java.lang.System.nanoTime;

public class Main {
    public static void main(String[] args){
        MyRunnable runnable = new MyRunnable();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        String folderPath = "src/files/";
        File folder = new File(folderPath);
        for (File file : folder.listFiles()) {
            runnable.addFile(folderPath + file.getName());
        }
        long startTime = nanoTime();
        threadPool.execute(runnable);
        runnable.run();
        long endTime = nanoTime();
        threadPool.shutdown();
        Map<String, Integer> mapFinal = runnable.getStatisticList();
        for (Map.Entry<String, Integer> entry : mapFinal.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println((endTime-startTime)/(1000));
    }
}