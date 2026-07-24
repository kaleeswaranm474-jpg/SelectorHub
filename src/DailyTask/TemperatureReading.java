package DailyTask;

import java.util.Scanner;

public class TemperatureReading {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] personName = new String[3];
        String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        double[][] temperature = new double[3][7];

        for (int i = 0; i < 3; i++) {

            System.out.print("Enter Person " + (i + 1) + " Name: ");
            personName[i] = sc.next();

            System.out.println("Enter Temperature for " + personName[i]);

            for (int j = 0; j < 7; j++) {

                System.out.print(days[j] + " : ");
                temperature[i][j] = sc.nextDouble();
            }
        }

       
        double overallHighest = temperature[0][0];
        String highestPerson = personName[0];

        double overallLowest = temperature[0][0];
        String lowestPerson = personName[0];

        System.out.println("\n========== TEMPERATURE REPORT ==========");

       
        for (int i = 0; i < 3; i++) {

            double total = 0;
            double highest = temperature[i][0];
            double lowest = temperature[i][0];

            for (int j = 0; j < 7; j++) {

                total += temperature[i][j];

                if (temperature[i][j] > highest) {
                    highest = temperature[i][j];
                }

                if (temperature[i][j] < lowest) {
                    lowest = temperature[i][j];
                }
            }

            double average = total / 7;

       
            if (highest > overallHighest) {
                overallHighest = highest;
                highestPerson = personName[i];
            }

            if (lowest < overallLowest) {
                overallLowest = lowest;
                lowestPerson = personName[i];
            }

            System.out.println("--------------------------------------");
            System.out.println("Person Name         : " + personName[i]);
            System.out.println("Highest Temperature : " + highest + " °C");
            System.out.println("Lowest Temperature  : " + lowest + " °C");
            System.out.println("Average Temperature : " + average + " °C");
        }

      
        System.out.println("\n========== OVERALL REPORT ==========");
        System.out.println("Highest Temperature : " + overallHighest + " °C");
        System.out.println("Person              : " + highestPerson);

        System.out.println("Lowest Temperature  : " + overallLowest + " °C");
        System.out.println("Person              : " + lowestPerson);

        System.out.println("\nTreatment Status");
        System.out.println(highestPerson + " should receive treatment first.");
        System.out.println("Reason: Highest recorded temperature is " + overallHighest + " °C.");

        sc.close();
    }
}