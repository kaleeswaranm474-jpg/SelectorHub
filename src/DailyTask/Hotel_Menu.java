package DailyTask;

import java.util.Scanner;

public class Hotel_Menu {

	public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);

		        System.out.println("===== Welcome to Hotel =====");
		        System.out.println("1. Breakfast");
		        System.out.println("2. Lunch");
		        System.out.println("3. Dinner");
		        System.out.print("Select your meal: ");
		        int meal = sc.nextInt();

		        switch (meal) {

		            case 1:
		                System.out.println("\n--- Breakfast Menu ---");
		                System.out.println("1. Idli - Rs.40");
		                System.out.println("2. Dosa - Rs.60");
		                System.out.println("3. Pongal - Rs.70");
		                System.out.print("Choose your food: ");
		                int breakfast = sc.nextInt();

		                switch (breakfast) {
		                    case 1:
		                        System.out.println("You ordered Idli. Price: Rs.40");
		                        break;
		                    case 2:
		                        System.out.println("You ordered Dosa. Price: Rs.60");
		                        break;
		                    case 3:
		                        System.out.println("You ordered Pongal. Price: Rs.70");
		                        break;
		                    default:
		                        System.out.println("Invalid food choice.");
		                }
		                break;

		            case 2:
		                System.out.println("\n--- Lunch Menu ---");
		                System.out.println("1. Meals - Rs.150");
		                System.out.println("2. Chicken Biryani - Rs.250");
		                System.out.println("3. Fried Rice - Rs.180");
		                System.out.print("Choose your food: ");
		                int lunch = sc.nextInt();

		                switch (lunch) {
		                    case 1:
		                        System.out.println("You ordered Meals. Price: Rs.150");
		                        break;
		                    case 2:
		                        System.out.println("You ordered Chicken Biryani. Price: Rs.250");
		                        break;
		                    case 3:
		                        System.out.println("You ordered Fried Rice. Price: Rs.180");
		                        break;
		                    default:
		                        System.out.println("Invalid food choice.");
		                }
		                break;

		            case 3:
		                System.out.println("\n--- Dinner Menu ---");
		                System.out.println("1. Chapati - Rs.80");
		                System.out.println("2. Parotta - Rs.100");
		                System.out.println("3. Noodles - Rs.160");
		                System.out.print("Choose your food: ");
		                int dinner = sc.nextInt();

		                switch (dinner) {
		                    case 1:
		                        System.out.println("You ordered Chapati. Price: Rs.80");
		                        break;
		                    case 2:
		                        System.out.println("You ordered Parotta. Price: Rs.100");
		                        break;
		                    case 3:
		                        System.out.println("You ordered Noodles. Price: Rs.160");
		                        break;
		                    default:
		                        System.out.println("Invalid food choice.");
		                }
		                break;

		            default:
		                System.out.println("Invalid meal selection.");
		        }

		        sc.close();
		    }

}
