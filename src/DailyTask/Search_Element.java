package DailyTask;

import java.util.Scanner;

public class Search_Element {

	public static void main(String[] args) {
		
		        Scanner sc = new Scanner(System.in);

		        int[] arr = {10, 20, 30, 40, 50};

		        System.out.print("Enter the element to search: ");
		        int search = sc.nextInt();

		        int index = -1;

		        for (int i = 0; i < arr.length; i++) {

		            if (arr[i] == search) {
		                index = i;
		                break;
		            }

		        }

		        if (index != -1) {
		            System.out.println("Element found at index position: " + index);
		        } else {
		            System.out.println("Element not found in the array.");
		        }

		        sc.close();
		    }
		}

	
