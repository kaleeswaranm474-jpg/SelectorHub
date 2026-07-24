package DailyTask;

import java.util.Scanner;

public class EmployeeSalaryProcessing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] salary = new double[3][5]; 
        String[] employeeName = new String[3];

      
        for (int i = 0; i < 3; i++) {

            System.out.print("Enter Employee " + (i + 1) + " Name: ");
            employeeName[i] = sc.next();

            System.out.println("Enter 5 Months Salary for " + employeeName[i]);

            for (int j = 0; j < 5; j++) {
                System.out.print("Month " + (j + 1) + " Salary: ");
                salary[i][j] = sc.nextDouble();
            }
        }

        System.out.println("\n========== Employee Salary Report ==========");

       
        double highestAverage = 0;
        String highestAverageEmployee = "";

        double overallHighestSalary = salary[0][0];
        String highestSalaryEmployee = employeeName[0];

        double overallLowestSalary = salary[0][0];
        String lowestSalaryEmployee = employeeName[0];

       
        for (int i = 0; i < 3; i++) {

            double total = 0;
            double highest = salary[i][0];
            double lowest = salary[i][0];

            for (int j = 0; j < 5; j++) {

                total += salary[i][j];

                if (salary[i][j] > highest) {
                    highest = salary[i][j];
                }

                if (salary[i][j] < lowest) {
                    lowest = salary[i][j];
                }
            }

            double average = total / 5;

         
            if (average > highestAverage) {
                highestAverage = average;
                highestAverageEmployee = employeeName[i];
            }

      
            if (highest > overallHighestSalary) {
                overallHighestSalary = highest;
                highestSalaryEmployee = employeeName[i];
            }

       
            if (lowest < overallLowestSalary) {
                overallLowestSalary = lowest;
                lowestSalaryEmployee = employeeName[i];
            }

         
            System.out.println("--------------------------------------");
            System.out.println("Employee Name : " + employeeName[i]);

            for (int j = 0; j < 5; j++) {
                System.out.println("Month " + (j + 1) + " Salary : " + salary[i][j]);
            }

            System.out.println("Total Salary   : " + total);
            System.out.println("Average Salary : " + average);
            System.out.println("Highest Salary : " + highest);
            System.out.println("Lowest Salary  : " + lowest);
        }

        
        System.out.println("\n========== Overall Salary Report ==========");
        System.out.println("Highest Average Salary Employee : " + highestAverageEmployee);
        System.out.println("Highest Average Salary          : " + highestAverage);

        System.out.println("Highest Salary Employee         : " + highestSalaryEmployee);
        System.out.println("Highest Salary                  : " + overallHighestSalary);

        System.out.println("Lowest Salary Employee          : " + lowestSalaryEmployee);
        System.out.println("Lowest Salary                   : " + overallLowestSalary);

        sc.close();
    }
}