import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordsStatistic {
    public static Map<String, Integer> getWordStatisctic(String filename) {
        Map<String, Integer> statisticMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String value;
            while ((value = reader.readLine()) != null) {
                sb.append(value.toLowerCase());
                sb.append(" ");
            }
            if (sb.isEmpty()) {
                return null;
            }
            String textFromFile = sb.toString();
            String[] splittedText = textFromFile.split("[\n|.|,|/|\s|[0-9]]");
            List<String> list = Arrays.asList(splittedText);
            for (String i : list) {
                if (!statisticMap.containsKey(i)) {
                    statisticMap.put(i, Collections.frequency(list, i));
                }
            }
            return statisticMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static synchronized void writeInMap(Map<String, Integer> map, Map<String, Integer> mapWithStatistic) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (mapWithStatistic.containsKey(entry.getKey())) {
                mapWithStatistic.replace(entry.getKey(), mapWithStatistic.get(entry.getKey()) + map.get(entry.getKey()));
            } else
                mapWithStatistic.put(entry.getKey(), map.get(entry.getKey()));
        }
    }
}
