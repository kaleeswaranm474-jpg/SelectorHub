package DailyTask;

import java.util.Scanner;


public class Prime_Number {

	public static void main(String[] args) {
				
		        Scanner sc = new Scanner(System.in);

		        System.out.print("Enter a number: ");
		        int num = sc.nextInt();

		        int i = 2;

		        while (i < num) {
		            if (num % i == 0) {
		                System.out.println("Not a Prime Number");
		                return;
		            }
		            i++;
		        }

		        if (num > 1)
		            System.out.println("Prime Number");
		        else
		            System.out.println("Not a Prime Number");
		    
	}

}
