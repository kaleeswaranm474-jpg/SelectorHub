package DailyTask;

import java.util.Scanner;

public class FoodDeliverySystems {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Delivery Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Food Amount: ₹");
        double amount = sc.nextDouble();

        System.out.print("Enter Distance (km): ");
        double distance = sc.nextDouble();

        System.out.println("\n1. Zomato");
        System.out.println("2. Swiggy");
        System.out.println("3. Exit");
        System.out.print("Choose Service: ");
        int choice = sc.nextInt();

        FoodDelivery food;

        switch (choice) {

            case 1:
                food = new Zomato(name, address, amount, distance);
                break;

            case 2:
                food = new Swiggy(name, address, amount, distance);
                break;

            case 3:
                System.out.println("Thank you for using Food Delivery System.");
                sc.close();
                return;

            default:
                System.out.println("Invalid Choice");
                sc.close();
                return;
        }

        System.out.println();
        food.deliverFood();
        food.calculateAmount();

        sc.close();
    }
}