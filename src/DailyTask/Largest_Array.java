package DailyTask;

public class Largest_Array {

	public static void main(String[] args) {

		        int[] arr = {10, 25, 8, 45, 30};

		        int largest = arr[0];

		        for (int i = 1; i < arr.length; i++) {

		            if (arr[i] > largest) {
		                largest = arr[i];
		            }

		        }

		        System.out.println("Largest element = " + largest);
		    }
		}
	
