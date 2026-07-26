package ProjectThree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OnlineVotingSystem {

    static Scanner sc = new Scanner(System.in);

    // Store Users (Voter ID -> User)
    static HashMap<String, User> users = new HashMap<>();

    // Store Candidates
    static ArrayList<Candidate> candidates = new ArrayList<>();

    // Store Voting Details
    static HashMap<String, Voting> votingDetails = new HashMap<>();


    // ==============================
    // Safe Integer Reader (crash-proof)
    // ==============================

    static int readInt() {

        if(sc.hasNextInt()) {

            return sc.nextInt();
        }

        sc.next();   // discard the invalid (non-numeric) token
        return -1;   // sentinel value; -1 never matches a valid menu/ID
    }


    // ==============================
    // Default Tamil Nadu Candidates
    // ==============================

    static void addDefaultCandidates() {

        candidates.add(new Candidate(101, "M.K. Stalin", "DMK"));
        candidates.add(new Candidate(102, "Edappadi K. Palaniswami", "AIADMK"));
        candidates.add(new Candidate(103, "Vijay", "TVK"));
        candidates.add(new Candidate(104, "Annamalai", "BJP"));
        candidates.add(new Candidate(105, "Seeman", "NTK"));

    }


    // ==============================
    // Main Menu
    // ==============================

    static void mainMenu() {

        
        System.out.println("\n*************************************************");
        System.out.println("*                                               *");
        System.out.println("*          ONLINE VOTING SYSTEM                 *");
        System.out.println("*                                               *");
        System.out.println("*************************************************");
        System.out.println();
        System.out.println("1. User Module");
        System.out.println("2. Admin Login");
        System.out.println("3. Exit");
        System.out.print("Enter Your Choice : ");

    }


    // ==============================
    // User Module - Entry Menu (Level 1)
    // ==============================

    static void userEntryMenu() {

        System.out.println("\n========== USER MODULE ==========");
        System.out.println("1. Register User (id & password)");
        System.out.println("2. Already Registered User (id & password)");
        System.out.println("3. Back");
        System.out.print("Enter Your Choice : ");

    }


    // ==============================
    // User Module - Actions Menu (Level 2)
    // ==============================

    static void userActionsMenu() {

        int choice;

        do {

            System.out.println("\n========== USER MODULE ==========");
            System.out.println("1. Login (Cast Vote)");
            System.out.println("2. View Candidates");
            System.out.println("3. View Result");
            System.out.println("4. Back");
            System.out.print("Enter Your Choice : ");

            choice = readInt();

            switch(choice) {

            case 1:

                User user = loginUser();

                if(user != null) {

                    castVote(user);
                }

                break;

            case 2:
                viewCandidates();
                break;

            case 3:
                displayResult();
                break;

            case 4:
                break;

            default:
                System.out.println("Invalid Choice.");
            }

        } while(choice != 4);

    }


    // ==============================
    // Admin Login
    // ==============================

    static boolean adminLogin() {

        System.out.print("Enter Admin Username : ");
        String username = sc.next();

        System.out.print("Enter Admin Password : ");
        String password = sc.next();

        if(username.equals("Vishnu") &&
           password.equals("Vishnu123")) {

            System.out.println("\nAdmin Login Successful...");
            return true;
        }

        System.out.println("\nInvalid Admin Username or Password");
        return false;

    }


    // ==============================
    // Admin Menu
    // ==============================

    static void adminMenu() {

        System.out.println("\n========== ADMIN MODULE ==========");
        System.out.println("1. Add Candidate");
        System.out.println("2. Remove Candidate");
        System.out.println("3. View Candidates");
        System.out.println("4. View Result");
        System.out.println("5. Logout");
        System.out.print("Enter Your Choice : ");

    }
    // ==============================
    // Register User
    // ==============================

    static void registerUser() {

        sc.nextLine();

        System.out.print("Enter Voter ID : ");
        String voterId = sc.nextLine();

        if(users.containsKey(voterId)) {
            System.out.println("Voter ID Already Registered.");
            return;
        }

        System.out.print("Enter User Name : ");
        String userName = sc.nextLine();

        int age;

        while(true) {

            System.out.print("Enter Age : ");

            if(sc.hasNextInt()) {

                age = sc.nextInt();

                if(age > 0) {
                    break;
                }

                System.out.println("Invalid Age. Please Enter A Positive Number.");

            } else {

                System.out.println("Invalid Age. Please Enter A Number.");
                sc.next();
            }
        }

        if(age < 18) {
            System.out.println("You are not eligible to vote.");
            return;
        }

        // Logical Duplicate Check: same Name + Age already registered
        for(User u : users.values()) {

            if(u.getUserName().equalsIgnoreCase(userName)
                    &&
               u.getAge() == age) {

                System.out.println("User Already Registered (Same Name & Age Found).");
                return;
            }
        }

        String phone;

        while(true) {

            System.out.print("Enter Phone Number (10 digits) : ");
            String enteredNumber = sc.next();

            if(enteredNumber.matches("[6-9][0-9]{9}")) {

                String candidatePhone = "+91" + enteredNumber;

                boolean duplicatePhone = false;

                for(User u : users.values()) {

                    if(u.getPhoneNumber().equals(candidatePhone)) {
                        duplicatePhone = true;
                        break;
                    }
                }

                if(duplicatePhone) {

                    System.out.println("This Phone Number Is Already Registered.");

                } else {

                    phone = candidatePhone;
                    break;
                }

            } else {

                System.out.println("Invalid Phone Number.");
                System.out.println("Phone number must be 10 digits starting with 6/7/8/9");
            }
        }

        sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        User user = new User(
                voterId,
                userName,
                password,
                age,
                phone);

        users.put(voterId, user);

        System.out.println("\nUser Registered Successfully.");
    }


    // ==============================
    // User Login
    // ==============================

    static User loginUser() {

        sc.nextLine();

        System.out.print("Enter Voter ID : ");
        String voterId = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        User user = users.get(voterId);

        if(user != null &&
           user.getPassword().equals(password)) {

            System.out.println("\nLogin Successful.");
            return user;
        }

        System.out.println("\nInvalid Voter ID or Password.");
        return null;
    }


    // ==============================
    // View Candidates
    // ==============================

    static void viewCandidates() {

        if(candidates.isEmpty()) {

            System.out.println("\nNo Candidates Available.");
            return;
        }

        System.out.println("\n========== CANDIDATE LIST ==========");

        for(Candidate candidate : candidates) {

            System.out.println("--------------------------------");

            System.out.println("Candidate ID   : "
                    + candidate.getCandidateId());

            System.out.println("Candidate Name : "
                    + candidate.getCandidateName());

            System.out.println("Party Name     : "
                    + candidate.getPartyName());

            System.out.println("--------------------------------");
        }

    }
    // ==============================
    // Cast Vote
    // ==============================

    static void castVote(User user) {

        if(user == null) {
            System.out.println("Please Login First.");
            return;
        }

        if(user.isVoted()) {
            System.out.println("You Have Already Voted.");
            return;
        }

        viewCandidates();

        System.out.print("Enter Candidate ID : ");

        if(!sc.hasNextInt()) {

            System.out.println("Invalid Candidate ID (must be a number).");
            sc.next();
            return;
        }

        int id = sc.nextInt();

        for(Candidate candidate : candidates) {

            if(candidate.getCandidateId() == id) {

                candidate.addVote();

                user.setVoted(true);

                Voting voting = new Voting(user, candidate);

                votingDetails.put(user.getVoterId(), voting);

                System.out.println("\nVote Cast Successfully.");
                return;
            }
        }

        System.out.println("Invalid Candidate ID.");
    }


    // ==============================
    // View Result
    // ==============================

    static void displayResult() {

        if(candidates.isEmpty()) {

            System.out.println("No Candidates Available.");
            return;
        }

        Candidate winner = candidates.get(0);

        System.out.println("\n========== ELECTION RESULT ==========");

        for(Candidate candidate : candidates) {

            System.out.println(
                    candidate.getCandidateName()
                    + " ("
                    + candidate.getPartyName()
                    + ") : "
                    + candidate.getVotes()
                    + " Votes");

            if(candidate.getVotes() > winner.getVotes()) {

                winner = candidate;
            }
        }

        // Check if more than one candidate shares the highest vote count
        int tieCount = 0;

        for(Candidate candidate : candidates) {

            if(candidate.getVotes() == winner.getVotes()) {

                tieCount++;
            }
        }

        System.out.println("\n==============================");

        if(tieCount > 1 && winner.getVotes() > 0) {

            System.out.println("Result : TIE");
            System.out.println("The Following Candidates Are Tied With "
                    + winner.getVotes() + " Votes Each:");

            for(Candidate candidate : candidates) {

                if(candidate.getVotes() == winner.getVotes()) {

                    System.out.println("- "
                            + candidate.getCandidateName()
                            + " (" + candidate.getPartyName() + ")");
                }
            }

        } else {

            System.out.println("Winner : " + winner.getCandidateName());
            System.out.println("Party  : " + winner.getPartyName());
            System.out.println("Votes  : " + winner.getVotes());
        }

        System.out.println("==============================");
    }


    // ==============================
    // Add Candidate (Admin Only)
    // ==============================

    static void addCandidate() {

        System.out.print("Enter Candidate ID : ");

        if(!sc.hasNextInt()) {

            System.out.println("Invalid Candidate ID (must be a number).");
            sc.next();
            return;
        }

        int id = sc.nextInt();

        sc.nextLine();

        // Duplicate Candidate ID Check
        for(Candidate c : candidates) {

            if(c.getCandidateId() == id) {

                System.out.println("Candidate ID Already Exists.");
                return;
            }
        }

        System.out.print("Enter Candidate Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Party Name : ");
        String party = sc.nextLine();

        Candidate candidate =
                new Candidate(id, name, party);

        candidates.add(candidate);

        System.out.println("\nCandidate Added Successfully.");
    }


    // ==============================
    // Remove Candidate (Admin Only)
    // ==============================

    static void removeCandidate() {

        System.out.print("Enter Candidate ID : ");

        if(!sc.hasNextInt()) {

            System.out.println("Invalid Candidate ID (must be a number).");
            sc.next();
            return;
        }

        int id = sc.nextInt();

        for(Candidate c : candidates) {

            if(c.getCandidateId() == id) {

                if(c.getVotes() > 0) {

                    System.out.println("Cannot Remove: This Candidate Already Has "
                            + c.getVotes() + " Vote(s) Recorded.");
                    return;
                }

                candidates.remove(c);

                System.out.println("\nCandidate Removed Successfully.");
                return;
            }
        }

        System.out.println("Candidate Not Found.");
    }
    
    // ==============================
    // Main Method
    // ==============================

    public static void main(String[] args) {

        // Default Candidates
        addDefaultCandidates();

        int mainChoice;

        do {

            mainMenu();
            mainChoice = readInt();

            switch(mainChoice) {

            // =========================
            // USER MODULE
            // =========================

            case 1:

                int userEntryChoice;

                do {

                    userEntryMenu();
                    userEntryChoice = readInt();

                    switch(userEntryChoice) {

                    case 1:

                        registerUser();

                        userActionsMenu();

                        break;

                    case 2:

                        userActionsMenu();

                        break;

                    case 3:

                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println("Invalid Choice.");
                    }

                } while(userEntryChoice != 3);

                break;


            // =========================
            // ADMIN MODULE
            // =========================

            case 2:

                if(adminLogin()) {

                    int adminChoice;

                    do {

                        adminMenu();
                        adminChoice = readInt();

                        switch(adminChoice) {

                        case 1:
                            addCandidate();
                            break;

                        case 2:
                            removeCandidate();
                            break;

                        case 3:
                            viewCandidates();
                            break;

                        case 4:
                            displayResult();
                            break;

                        case 5:
                            System.out.println("Admin Logout Successfully...");
                            break;

                        default:
                            System.out.println("Invalid Choice.");
                        }

                    } while(adminChoice != 5);

                }

                break;


            // =========================
            // EXIT
            // =========================

            case 3:

                System.out.println("\n==================================");
                System.out.println(" Thank You For Using");
                System.out.println(" Online Voting System");
                System.out.println("==================================");

                break;

            default:
                System.out.println("Invalid Choice.");
            }

        } while(mainChoice != 3);

        sc.close();
    }
}
