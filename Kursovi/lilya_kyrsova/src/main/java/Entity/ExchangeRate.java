package Entity;


import java.util.ArrayList;
import java.util.List;

public class ExchangeRate {
List<Currency> list;

    public int getLength() {
        return length;
    }

    int length=0;
    public ExchangeRate() {
        list=new ArrayList<>();
    }

    public List<Currency> getList() {
        return list;
    }

    public void addToList(Currency a) {
        list.add(a);
        length++;
    }

}
