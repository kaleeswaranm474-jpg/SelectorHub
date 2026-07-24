package DailyTask;

import java.util.Scanner;


class Account {

    String accountHolder;
    double balance;

    
    Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void showBalance() {
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Current Balance : ₹" + balance);
    }
}


class ATM extends Account {

    ATM(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount should be greater than zero.");
        }
    }

    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount cannot be negative or zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if ((balance - amount) < 1000) {
            System.out.println("Minimum balance of ₹1000 must be maintained.");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }
}

class ATMMachine extends ATM {

    private int correctPIN = 2873;

    ATMMachine(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    boolean verifyPIN(int enteredPIN) {
        return enteredPIN == correctPIN;
    }

    void doTransaction(int enteredPIN, int choice, double amount) {

        if (verifyPIN(enteredPIN)) {

            System.out.println("PIN Verified.");

            switch (choice) {

                case 1:
                    withdraw(amount);
                    break;

                case 2:
                    deposit(amount);
                    break;

                case 3:
                    showBalance();
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

            if (choice != 3) {
                showBalance();
            }

        } else {
            System.out.println("Invalid PIN.");
        }
    }
}


public class ATMTransaction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ATMMachine atm = new ATMMachine("Vishnu", 6000);

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        System.out.println("\n1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        double amount = 0;

        if (choice == 1 || choice == 2) {
            System.out.print("Enter Amount: ");
            amount = sc.nextDouble();
        }

        atm.doTransaction(pin, choice, amount);

        sc.close();
    }
}