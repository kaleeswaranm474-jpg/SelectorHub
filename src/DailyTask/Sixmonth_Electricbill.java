package DailyTask;

import java.util.Scanner;

public class Sixmonth_Electricbill {

		    public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);

		        double units, bill, totalBill = 0;

		        for (int month = 1; month <= 6; month++) {

		            System.out.println("Enter units consumed for Month " + month + ":");
		            units = sc.nextDouble();

		            bill = units * 8;   // Rs.8 per unit

		            System.out.println("Bill for Month " + month + " = Rs." + bill);

		            totalBill = totalBill + bill;
		        }

		        System.out.println("----------------------------");
		        System.out.println("Total Bill for 6 Months = Rs." + totalBill);

		        sc.close();
	}

}
