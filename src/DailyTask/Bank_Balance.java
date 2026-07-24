package DailyTask;

import java.util.Scanner;

public class Bank_Balance {

	public static void main(String[] args) {
	
		        Scanner sc = new Scanner(System.in);

		        double balance = 1000;
		        int choice;
		        double amount;

		        System.out.println("===== BANK MENU =====");
		        System.out.println("1. Deposit");
		        System.out.println("2. Withdraw");
		        System.out.println("3. Show Balance");
		        System.out.print("Enter your choice: ");
		        choice = sc.nextInt();

		        switch (choice) {

		            case 1:
		                System.out.print("Enter deposit amount: ");
		                amount = sc.nextDouble();
		                balance = balance + amount;
		                System.out.println("Deposit Successful.");
		                System.out.println("Current Balance: " + balance);
		                break;

		            case 2:
		                System.out.print("Enter withdrawal amount: ");
		                amount = sc.nextDouble();

		                if (amount <= balance) {
		                    balance = balance - amount;
		                    System.out.println("Withdrawal Successful.");
		                    System.out.println("Current Balance: " + balance);
		                } else {
		                    System.out.println("Balance is too low.");
		                }
		                break;

		            case 3:
		                System.out.println("Current Balance: " + balance);
		                break;

		            default:
		                System.out.println("Invalid Choice.");
		        }

		        sc.close();

	}

}
