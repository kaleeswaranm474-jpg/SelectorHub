package DailyTask;

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Chennai");
        cities.add("Madurai");

        cities.addFirst("Coimbatore");
        cities.addLast("Trichy");

        System.out.println(cities);

        System.out.println("First : " + cities.getFirst());
        System.out.println("Last : " + cities.getLast());

        cities.offerFirst("Salem");
        cities.offerLast("Erode");

        System.out.println(cities);

        System.out.println("Peek First : " + cities.peekFirst());
        System.out.println("Peek Last : " + cities.peekLast());

        cities.pollFirst();
        cities.pollLast();

        System.out.println("After Poll : " + cities);

        cities.removeFirst();
        cities.removeLast();

        System.out.println("After Remove : " + cities);
    }
}