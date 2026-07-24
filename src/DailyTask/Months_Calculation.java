package DailyTask;

import java.util.Scanner;

public class Months_Calculation {

	public static void main(String[] args) {
		

		        Scanner sc = new Scanner(System.in);

		        System.out.print("Enter Month (1-12): ");
		        int month = sc.nextInt();

		        System.out.print("Enter Year: ");
		        int year = sc.nextInt();

		        switch (month) {

		            // Months with 31 days
		            case 1:
		            case 3:
		            case 5:
		            case 7:
		            case 8:
		            case 10:
		            case 12:
		                System.out.println("31 Days");
		                break;

		            // Months with 30 days
		            case 4:
		            case 6:
		            case 9:
		            case 11:
		                System.out.println("30 Days");
		                break;

		            // February
		            case 2:
		                if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
		                    System.out.println("29 Days (Leap Year)");
		                } else {
		                    System.out.println("28 Days");
		                }
		                break;

		            default:
		                System.out.println("Invalid Month");
		        }

		        sc.close();
		    }

}
