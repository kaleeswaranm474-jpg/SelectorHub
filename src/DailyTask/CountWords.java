package DailyTask;

import java.io.File;
import java.util.Scanner;

public class CountWords {

    public static void main(String[] args) {

        try {
            File file = new File("Employee.txt");
            Scanner sc = new Scanner(file);

            int wordCount = 0;

            while (sc.hasNext()) {
                sc.next();
                wordCount++;
            }

            sc.close();

            System.out.println("Total Words = " + wordCount);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}