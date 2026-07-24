package DailyTask;

import java.util.Scanner;

public class Electricity_Bill {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter units consumed: ");
	        int units = sc.nextInt();

	        double bill;

	        if (units <= 100) {
	            bill = units * 0;
	        }
	        else if (units <= 200) {
	            bill = (100 * 0) + ((units - 100) * 2.35);
	        }
	        else {
	            bill = (100 * 0) + (100 * 2.35) + ((units - 200) * 4.70);
	        }

	        System.out.println("Electricity Bill = ₹" + bill);

	      

	}

}
