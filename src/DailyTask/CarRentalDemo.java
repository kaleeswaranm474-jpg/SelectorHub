package DailyTask;

import java.util.Scanner;

class CarRental {

   
    void calculateRent(int hours) {
        int ratePerHour = 200;
        int rent = hours * ratePerHour;

        System.out.println("Rent based on Hours: Rs. " + rent);
    }

   
    void calculateRent(int days, double ratePerDay) {
        double rent = days * ratePerDay;

        System.out.println("Rent based on Days: Rs. " + rent);
    }

  
    void calculateRent(int days, boolean driver) {
        int ratePerDay = 1500;
        int driverCharge = 500;
        int rent;

        if (driver) {
            rent = (days * ratePerDay) + (days * driverCharge);
            System.out.println("Rent with Driver: Rs. " + rent);
        } else {
            rent = days * ratePerDay;
            System.out.println("Rent without Driver: Rs. " + rent);
        }
    }
}

public class CarRentalDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CarRental car = new CarRental();

        
        System.out.print("Enter Hours: ");
        int hours = sc.nextInt();
        car.calculateRent(hours);

      
        System.out.print("\nEnter Days: ");
        int days = sc.nextInt();

        System.out.print("Enter Rate Per Day: ");
        double rate = sc.nextDouble();

        car.calculateRent(days, rate);

    
        System.out.print("\nEnter Rental Days: ");
        int rentalDays = sc.nextInt();

        System.out.print("Need Driver? (true/false): ");
        boolean driver = sc.nextBoolean();

        car.calculateRent(rentalDays, driver);

        sc.close();
    }
}