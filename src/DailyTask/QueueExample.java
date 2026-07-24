package DailyTask;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        queue.add("Customer 1");
        queue.offer("Customer 2");
        queue.offer("Customer 3");

        System.out.println(queue);

        System.out.println("Element : " + queue.element());

        System.out.println("Peek : " + queue.peek());

        System.out.println("Remove : " + queue.remove());

        System.out.println(queue);

        System.out.println("Poll : " + queue.poll());

        System.out.println(queue);
    }
}