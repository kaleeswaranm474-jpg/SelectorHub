package DailyTask;
import java.util.Scanner;


public class Student_mark {

	public static void main(String[] args) {


		        Scanner sc = new Scanner(System.in);

		        System.out.print("Enter Student Name: ");
		        String name = sc.nextLine();

		        System.out.print("Enter Tamil Mark: ");
		        int tamil = sc.nextInt();

		        System.out.print("Enter English Mark: ");
		        int english = sc.nextInt();

		        System.out.print("Enter Maths Mark: ");
		        int maths = sc.nextInt();

		        System.out.print("Enter Science Mark: ");
		        int science = sc.nextInt();

		        System.out.print("Enter Social Mark: ");
		        int social = sc.nextInt();

		        int total = tamil + english + maths + science + social;
		        double average = total / 5.0;

		        System.out.println("\n----- Student Report -----");
		        System.out.println("Name    : " + name);
		        System.out.println("Total   : " + total);
		        System.out.println("Average : " + average);

		    }
		}
		
	
