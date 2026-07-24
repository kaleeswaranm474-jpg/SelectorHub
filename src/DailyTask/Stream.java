package DailyTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);

        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());

        System.out.println("Original List : " + numbers);
        System.out.println("Even Numbers : " + evenNumbers);
    }
}