package DailyTask;

import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();

        // add()
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");

        // add(index, element)
        fruits.add(1, "Banana");

        System.out.println("List : " + fruits);

        // get()
        System.out.println("Get : " + fruits.get(2));

        // set()
        fruits.set(0, "Pineapple");
        System.out.println("After Set : " + fruits);

        // contains()
        System.out.println("Contains Mango : " + fruits.contains("Mango"));

        // indexOf()
        System.out.println("Index of Mango : " + fruits.indexOf("Mango"));

        // lastIndexOf()
        fruits.add("Mango");
        System.out.println("Last Index of Mango : " + fruits.lastIndexOf("Mango"));

        // size()
        System.out.println("Size : " + fruits.size());

        // remove()
        fruits.remove("Orange");
        System.out.println("After Remove : " + fruits);

        // isEmpty()
        System.out.println("Is Empty : " + fruits.isEmpty());

        // clear()
        fruits.clear();
        System.out.println("After Clear : " + fruits);
    }
}