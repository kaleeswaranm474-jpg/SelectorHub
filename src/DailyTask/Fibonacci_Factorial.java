package DailyTask;

import java.util.Scanner;

public class Fibonacci_Factorial {

	public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);

		        int choice;

		        do {
		            System.out.println("\n===== MENU =====");
		            System.out.println("1. Fibonacci Series");
		            System.out.println("2. Factorial");
		            System.out.println("3. Exit");
		            System.out.print("Enter your choice: ");
		            choice = sc.nextInt();

		            switch (choice) {

		                case 1:

		                    System.out.print("Enter the number of terms: ");
		                    int n = sc.nextInt();

		                    int first = 0, second = 1, next, i = 1;

		                    System.out.println("Fibonacci Series:");

		                    do {
		                        System.out.print(first + " ");

		                        next = first + second;
		                        first = second;
		                        second = next;

		                        i++;

		                    } while (i <= n);

		                    System.out.println();
		                    break;

		                case 2:

		                    System.out.print("Enter a number: ");
		                    int num = sc.nextInt();

		                    int fact = 1;
		                    int j = 1;

		                    do {
		                        fact = fact * j;
		                        j++;

		                    } while (j <= num);

		                    System.out.println("Factorial of " + num + " = " + fact);

		                    break;

		                case 3:
		                    System.out.println("Program Ended.");
		                    break;

		                default:
		                    System.out.println("Invalid Choice!");

		            }

		        } while (choice != 3);

		        sc.close();
		    }

}
