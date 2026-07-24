package DailyTask;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Kumar");
        names.add("Rahul");
        names.add("Arun");

        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}