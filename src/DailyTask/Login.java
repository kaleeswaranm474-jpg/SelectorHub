package DailyTask;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        boolean valid = true;

        if (password.length() != 10) {
            valid = false;
        } else {
            for (int i = 0; i < password.length(); i++) {
                if (!Character.isDigit(password.charAt(i))) {
                    valid = false;
                    break;
                }
            }
        }

        if (valid) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Password must contain exactly 10 digits.");
        }

        sc.close();
	}

}
