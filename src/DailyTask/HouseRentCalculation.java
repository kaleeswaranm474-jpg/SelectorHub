package DailyTask;

import java.util.Scanner;

public class HouseRentCalculation {

   
    public static void oneBHK() {

        System.out.println("\n----- 1 BHK DETAILS -----");
        System.out.println("Monthly Rent       : ₹8,000");
        System.out.println("Maintenance Charge : ₹500");
        System.out.println("Advance Amount     : ₹20,000");
        System.out.println("Parking            : Bike Only");
        System.out.println("Water Facility     : Available");
        System.out.println("Total First Payment: ₹28,500");
    }

  
    public static void twoBHK() {

        System.out.println("\n----- 2 BHK DETAILS -----");
        System.out.println("Monthly Rent       : ₹12,000");
        System.out.println("Maintenance Charge : ₹1,000");
        System.out.println("Advance Amount     : ₹30,000");
        System.out.println("Parking            : Car & Bike");
        System.out.println("Water Facility     : Available");
        System.out.println("Total First Payment: ₹43,000");
    }

    
    public static void threeBHK() {

        System.out.println("\n----- 3 BHK DETAILS -----");
        System.out.println("Monthly Rent       : ₹18,000");
        System.out.println("Maintenance Charge : ₹1,500");
        System.out.println("Advance Amount     : ₹50,000");
        System.out.println("Parking            : Car & Bike");
        System.out.println("Water Facility     : 24 Hours");
        System.out.println("Total First Payment: ₹69,500");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n========== HOUSE RENT MENU ==========");
            System.out.println("1. 1 BHK");
            System.out.println("2. 2 BHK");
            System.out.println("3. 3 BHK");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    oneBHK();
                    break;

                case 2:
                    twoBHK();
                    break;

                case 3:
                    threeBHK();
                    break;

                case 4:
                    System.out.println("Thank You! Visit Again.");
                    break;

                default:
                    System.out.println("Invalid Choice. Please Try Again.");
            }

        } while (choice != 4);

        sc.close();
    }
}