package DailyTask;

import java.io.File;
import java.io.IOException;

public class CreateDeleteFile {

    public static void main(String[] args) {

        try {
            File file = new File("Employee.txt");

            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }

          /*  if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("File could not be deleted.");
            }*/

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}