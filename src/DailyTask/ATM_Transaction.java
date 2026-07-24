package DailyTask;

import java.util.Scanner;

public class ATM_Transaction {

    static double balance = 10000;

    public static void checkBalance() {
        System.out.println("Available Balance: ₹" + balance);
    }

   
    public static void deposit(Scanner sc) {
        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();

        balance = balance + amount;

        System.out.println("Deposit Successful.");
        System.out.println("Updated Balance: ₹" + balance);
    }

   
    public static void withdraw(Scanner sc) {
        System.out.print("Enter Withdrawal Amount: ");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawal Successful.");
            System.out.println("Remaining Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit(sc);
                    break;

                case 3:
                    withdraw(sc);
                    break;

                case 4:
                    System.out.println("Thank You for Using the ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }

        sc.close();
    }
}