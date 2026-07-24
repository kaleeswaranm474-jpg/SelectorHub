package DailyTask;
import java.util.Scanner;

public class Employee_Payroll {

	public static void main(String[] args) {
	
	
	        Scanner sc = new Scanner(System.in);

	        // Input
	        System.out.print("Enter Employee ID: ");
	        int empId = sc.nextInt();

	        sc.nextLine(); // Clear buffer

	        System.out.print("Enter Employee Name: ");
	        String empName = sc.nextLine();

	        System.out.print("Enter Basic Salary: ");
	        double basicSalary = sc.nextDouble();

	        // Salary Calculations
	        double hra = basicSalary * 0.20;   // 20% House Rent Allowance
	        double da = basicSalary * 0.10;    // 10% Dearness Allowance
	        double pf = basicSalary * 0.08;    // 8% Provident Fund (PF)

	        double grossSalary = basicSalary + hra + da;
	        double netSalary = grossSalary - pf;

	        // Output
	        System.out.println("\n----- Employee Payroll -----");
	        System.out.println("Employee ID   : " + empId);
	        System.out.println("Employee Name : " + empName);
	        System.out.println("Basic Salary  : " + basicSalary);
	        System.out.println("HRA           : " + hra);
	        System.out.println("DA            : " + da);
	        System.out.println("PF            : " + pf);
	        System.out.println("Gross Salary  : " + grossSalary);
	        System.out.println("Net Salary    : " + netSalary);

	        sc.close();
	    }
	

	}
