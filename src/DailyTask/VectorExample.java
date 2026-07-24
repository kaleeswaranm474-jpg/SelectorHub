package DailyTask;

import java.util.Vector;

public class VectorExample {

    public static void main(String[] args) {

        Vector<String> names = new Vector<>();

        names.addElement("Kumar");
        names.addElement("Rahul");
        names.addElement("Arun");

        System.out.println(names);

        System.out.println("First : " + names.firstElement());
        System.out.println("Last : " + names.lastElement());

        System.out.println("Element At 1 : " + names.elementAt(1));

        System.out.println("Capacity : " + names.capacity());

        names.removeElement("Rahul");
        System.out.println(names);

        String[] arr = new String[names.size()];
        names.copyInto(arr);

        System.out.println("Copied Array");

        for(String name : arr)
        {
            System.out.println(name);
        }

        names.removeAllElements();

        System.out.println(names);
    }
}