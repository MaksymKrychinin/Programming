import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RarestWordFinder {



    public static String rarestWord(String filename){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))  {
            String value = "";
            while((value = reader.readLine()) !=null){
                sb.append(value);
                sb.append(" ");
            }
            String textFromFile = sb.toString();
            String[] splittedText = textFromFile.split("[^а-яєіїґА-ЯIҐЄЇ]");
            List<String> list = Arrays.asList(splittedText);
            int min = Integer.MAX_VALUE;
            int tmpMin =0;
            String stringToReturn = "";
            for(String i : list){
                tmpMin = Collections.frequency(list,i);
                if( tmpMin< min){
                    min = tmpMin;
                    stringToReturn = i;
                }
            }
            return stringToReturn;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
