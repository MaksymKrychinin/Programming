
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        String filename = "files/text.txt";
        String filename2 = "files/text2.txt";
        String filename3 = "files/text3.txt";
        Map<String, Integer> mapFinal = new HashMap<>();
        System.out.println("Rarest word: " + RarestWordFinder.rarestWord(filename));
        Runnable myThread1 = new MyThread(filename, mapFinal);
        Runnable myThread2 = new MyThread(filename2, mapFinal);
        Runnable myThread3 = new MyThread(filename3, mapFinal);
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        Thread thread3 = new Thread(myThread3);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        for (Map.Entry<String, Integer> entry : mapFinal.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}
