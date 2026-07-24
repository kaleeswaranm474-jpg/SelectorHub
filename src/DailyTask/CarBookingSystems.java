package DailyTask;

import java.util.Scanner;

public class CarBookingSystems {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Distance (km): ");
        double distance = sc.nextDouble();

        System.out.println("\n1. Mini Cab");
        System.out.println("2. Auto Cab");
        System.out.println("3. Sedan Cab");
        System.out.println("4. Exit");
        System.out.print("Choose Cab: ");
        int choice = sc.nextInt();

        CabBooking cab;

        switch (choice) {

            case 1:
                cab = new MiniCab(name, distance);
                break;

            case 2:
                cab = new AutoCab(name, distance);
                break;

            case 3:
                cab = new SedanCab(name, distance);
                break;

            case 4:
                System.out.println("Thank you for using Cab Booking System.");
                sc.close();
                return;

            default:
                System.out.println("Invalid Choice");
                sc.close();
                return;
        }

        System.out.println();
        cab.bookRide();
        cab.calculateFare();

        sc.close();
    }
}