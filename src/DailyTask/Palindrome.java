package DailyTask;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
	
		        Scanner sc = new Scanner(System.in);

		        System.out.print("Enter a string: ");
		        String str = sc.nextLine();

		        String rev = "";
		        int i = str.length() - 1;

		        while (i >= 0) {
		            rev = rev + str.charAt(i);
		            i--;
		        }

		        if (str.equals(rev)) {
		            System.out.println("Palindrome");
		        } else {
		            System.out.println("Not Palindrome");
		        }
		    }

	}


