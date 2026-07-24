package DailyTask;

import java.util.Scanner;

class UserAuthentication {

    // Login using Email and Password
    boolean login(String email, String password) {

        if (email.equals("user@gmail.com") && password.equals("12345")) {
            System.out.println("Login Successful using Email and Password.");
            return true;
        } else {
            System.out.println("Invalid Email or Password.");
            return false;
        }
    }

    // Login using Phone Number and OTP
    boolean login(long phoneNumber, int otp) {

        if (phoneNumber == 9876543210L && otp == 1234) {
            System.out.println("Login Successful using Phone Number and OTP.");
            return true;
        } else {
            System.out.println("Invalid Phone Number or OTP.");
            return false;
        }
    }

    // Login using Social ID
    boolean login(String socialId) {

        if (socialId.equals("google123")) {
            System.out.println("Login Successful using Social ID.");
            return true;
        } else {
            System.out.println("Invalid Social ID.");
            return false;
        }
    }
}

public class UserAuthenticationDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserAuthentication user = new UserAuthentication();

        boolean loginSuccess = false;

        while (!loginSuccess) {

            System.out.println("\n===== User Authentication =====");
            System.out.println("1. Login using Email and Password");
            System.out.println("2. Login using Phone Number and OTP");
            System.out.println("3. Login using Social ID");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Email: ");
                String email = sc.next();

                System.out.print("Enter Password: ");
                String password = sc.next();

                loginSuccess = user.login(email, password);
                break;

            case 2:

                System.out.print("Enter Phone Number: ");
                long phone = sc.nextLong();

                System.out.print("Enter OTP: ");
                int otp = sc.nextInt();

                loginSuccess = user.login(phone, otp);
                break;

            case 3:

                System.out.print("Enter Social ID: ");
                String socialId = sc.next();

                loginSuccess = user.login(socialId);
                break;

            case 4:

                System.out.println("Thank You! Exiting Program...");
                sc.close();
                return;

            default:

                System.out.println("Invalid Choice. Please Try Again.");
            }
        }

        System.out.println("\nWelcome!");

        sc.close();
    }
}