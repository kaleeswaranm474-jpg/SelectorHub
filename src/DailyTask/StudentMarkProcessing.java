package DailyTask;

import java.util.Scanner;

public class StudentMarkProcessing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] marks = new int[3][3];     
        String[] studentName = new String[3];

        
        for (int i = 0; i < 3; i++) {

            System.out.print("Enter Student " + (i + 1) + " Name: ");
            studentName[i] = sc.next();

            System.out.println("Enter marks for " + studentName[i]);

            for (int j = 0; j < 3; j++) {

                System.out.print("Subject " + (j + 1) + ": ");
                marks[i][j] = sc.nextInt();

                if (marks[i][j] > 100 || marks[i][j] < 0) {
                    System.out.println("Mark should be between 0 and 100. Enter again.");
                    j--; 
                }
            }
        }

        System.out.println("\n========== Student Mark Report ==========");

        for (int i = 0; i < 3; i++) {

            int total = 0;

            for (int j = 0; j < 3; j++) {
                total += marks[i][j];
            }

            double average = total / 3.0;

            System.out.println("-------------------------------------");
            System.out.println("Student Name : " + studentName[i]);
            System.out.println("Total Marks  : " + total);
            System.out.println("Average      : " + average);

            if (average >= 90) {
                System.out.println("Grade        : A");
            } else if (average >= 75) {
                System.out.println("Grade        : B");
            } else if (average >= 60) {
                System.out.println("Grade        : C");
            } else {
                System.out.println("Grade        : Fail");
            }
        }

        sc.close();
    }
}