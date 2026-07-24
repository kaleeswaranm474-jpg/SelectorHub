package DailyTask;

import java.util.Scanner;

public class AreaShapes {

	public static void main(String[] args) {
	

		        Scanner sc = new Scanner(System.in);

		        System.out.println("Choose a Shape:");
		        System.out.println("1. Circle");
		        System.out.println("2. Rectangle");
		        System.out.println("3. Triangle");
		        System.out.print("Enter your choice: ");
		        int choice = sc.nextInt();

		        switch (choice) {
		            case 1:
		                System.out.print("Enter radius: ");
		                double r = sc.nextDouble();
		                double circleArea = 3.14 * r * r;
		                System.out.println("Area of Circle = " + circleArea);
		                break;

		            case 2:
		                System.out.print("Enter length: ");
		                double length = sc.nextDouble();
		                System.out.print("Enter width: ");
		                double width = sc.nextDouble();
		                double rectangleArea = length * width;
		                System.out.println("Area of Rectangle = " + rectangleArea);
		                break;

		            case 3:
		                System.out.print("Enter base: ");
		                double base = sc.nextDouble();
		                System.out.print("Enter height: ");
		                double height = sc.nextDouble();
		                double triangleArea = 0.5 * base * height;
		                System.out.println("Area of Triangle = " + triangleArea);
		                break;

		            default:
		                System.out.println("Invalid Choice");
		        }

		        sc.close();
	}

}
