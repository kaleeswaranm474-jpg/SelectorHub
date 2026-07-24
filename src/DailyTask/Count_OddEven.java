package DailyTask;

public class Count_OddEven {

	public static void main(String[] args) {

		        int[] arr = {10, 15, 20, 25, 30, 35, 40};

		        int evenCount = 0;
		        int oddCount = 0;

		        for (int i = 0; i < arr.length; i++) {

		            if (arr[i] % 2 == 0) {
		                evenCount++;
		            } else {
		                oddCount++;
		            }

		        }

		        System.out.println("Number of Even Elements = " + evenCount);
		        System.out.println("Number of Odd Elements = " + oddCount);
		    }
		}
