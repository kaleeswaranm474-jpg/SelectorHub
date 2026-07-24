package DailyTask;

import java.util.Scanner;

public class Loan_Eligibility {

	public static void main(String[] args) {

	
		        Scanner sc = new Scanner(System.in);

		        System.out.print("Enter Monthly Salary: ");
		        double salary = sc.nextDouble();

		        System.out.print("Are you employed? (true/false): ");
		        boolean employed = sc.nextBoolean();

		        System.out.print("Enter CIBIL Score: ");
		        int cibil = sc.nextInt();

		        if (salary >= 25000 && employed == true && cibil >= 750) {
		            System.out.println("Loan Eligible");
		        } else {
		            System.out.println("Loan Not Eligible");
		        }

		        sc.close();
		    
		

	}

}
