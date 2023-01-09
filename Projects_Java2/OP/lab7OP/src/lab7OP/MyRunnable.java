package lab7OP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class MyRunnable implements Runnable {
    int numberOfFile = -1;
    List<String> fileList = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public void addFile(String fileName){
        fileList.add(fileName);
    }

    public static void Map(String filename, Map<String, Integer> map1) throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String value;
            while ((value = reader.readLine()) != null) {
                sb.append(value.toLowerCase());
                sb.append(" ");
            }
            String textFromFile = sb.toString();
            String[] splittedText = textFromFile.split("[\n|.|,|/|\s|[0-9]]");
            List<String> list = Arrays.asList(splittedText);
            for (String word : list) {
                synchronized (map1) {
                    if (map1.containsKey(word)) map1.put(word,
                            (map1.get(word) + 1));
                    else map1.put(word, 1);
                }
            }
        }
    }


    public Map<String, Integer> getStatisticList() {
        return map;
    }

    @Override
    public void run() {
        numberOfFile++;
        try {
            Map(fileList.get(numberOfFile), map);
        } catch (IOException | InterruptedException e) {
            e.getMessage();
        }
    }
}
