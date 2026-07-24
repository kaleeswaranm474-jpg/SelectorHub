package DailyTask;

import java.io.FileWriter;
import java.io.IOException;

public class WriteEmployeeData {

    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("Employee.txt");

            writer.write("Employee Details\n");
            writer.write("Name : Kaleeswaran\n");
            writer.write("EMP ID : 101\n");
            writer.write("Designation : Java Developer\n");
           

            writer.close();

            System.out.println("Employee data written successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}