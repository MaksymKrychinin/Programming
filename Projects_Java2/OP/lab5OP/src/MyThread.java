import java.util.Map;

public class MyThread implements Runnable{
    private String filename;
    private volatile Map<String,Integer> mapWithStatistic;
    public MyThread(String filename,Map<String,Integer> mapWithStatistic){
        this.filename =filename;
        this.mapWithStatistic = mapWithStatistic;
    }

    @Override
    public void run() {
        Map<String,Integer> newMap = WordsStatistic.getWordStatisctic(filename);
        if(newMap!=null) {
            WordsStatistic.writeInMap(newMap, mapWithStatistic);
        }
    }
}
