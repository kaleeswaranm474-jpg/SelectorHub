package DailyTask;

import java.util.Scanner;

public class Calculator {
	

	    public static void main(String[] args) {

	    	   Scanner sc = new Scanner(System.in);

		        Calculator c = new Calculator();  

		        System.out.print("Enter First Number: ");
		        
		        int a = sc.nextInt();

		        System.out.print("Enter Operator (+,-,*,/): ");
		        char op1 = sc.next().charAt(0);
		        
		        System.out.print("Enter Second Number: ");
		        int b = sc.nextInt();
		        
		        
		        switch (op1) {

	            case '+':
	                System.out.println("Addition = " + (a + b));
	                break;

	            case '-':
	                System.out.println("Subtraction = " + (a - b));
	                break;

	            case '*':
	                System.out.println("Multiplication = " + (a * b));
	                break;

	            case '/':
	                System.out.println("Division = " + (a / b));
	                break;

	            default:
	                System.out.println("Invalid Operator");

		        sc.close();
		    }
		}

	}


