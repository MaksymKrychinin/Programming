package Entity;


import java.util.ArrayList;
import java.util.List;

public class ExchangeRate {
    List<Currency> list;
    int length = 0;


    public int getLength() {
        return length;
    }

    public ExchangeRate() {
        list = new ArrayList<>();
    }

    public List<Currency> getList() {
        return list;
    }

    public void addToList(Currency currency) {
        list.add(currency);
        length++;
    }

}
