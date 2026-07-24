package DailyTask;

import java.io.*;

//import java.io.IOException;

public class Counts_Characters {

    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("Employee.txt");

            int ch;
            int vowels = 0;
            int digits = 0;
            int special = 0;

            while ((ch = reader.read()) != -1) {

                char c = (char) ch;

                if ("AEIOUaeiou".indexOf(c) != -1) {
                    vowels++;
                } else if (Character.isDigit(c)) {
                    digits++;
                } else if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                    special++;
                }
            }

            reader.close();

            System.out.println("Vowels = " + vowels);
            System.out.println("Digits = " + digits);
            System.out.println("Special Characters = " + special);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}