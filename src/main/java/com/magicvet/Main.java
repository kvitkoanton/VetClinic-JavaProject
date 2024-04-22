package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String PASSWORD = "default";
    static Scanner SCANNER;
    static String EMAIL_PATTERN;
    static String FIRST_LAST_NAME_PATTERN;

    public Main() {
    }

    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }

    }

    static boolean auth() {
        boolean accepted = false;

        for(int i = 0; i < 3; ++i) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();
            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            }

            System.out.println("Access denied. Please check your password.");
        }

        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked");
        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Please provide client details.");
        System.out.print("E-Mail: ");
        String email = SCANNER.nextLine();
        if (!isEmailValid(email)) {
            System.out.println("Providet E-Mail is invalid");
        } else {
            System.out.print("First name: ");
            String firstName = SCANNER.nextLine();
            if (!isFirstNamelValid(firstName)) {
                System.out.println("Providet First name is invalid");
            } else {
                System.out.print("Last name: ");
                String lastName = SCANNER.nextLine();
                if (!isLastNamelValid(lastName)) {
                    System.out.println("Providet Last name is invalid");
                } else {
                    Client client = buildClient(email, firstName, lastName);
                    System.out.println("New client: " + client.FirstName + " " + client.LastName + " (" + client.email + ")");
                }
            }
        }
    }

    private static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.email = email;
        client.FirstName = firstName;
        client.LastName = lastName;
        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean isFirstNamelValid(String firstName) {
        Pattern patternFirstName = Pattern.compile(FIRST_LAST_NAME_PATTERN);
        Matcher matcherFirstName = patternFirstName.matcher(firstName);
        return matcherFirstName.matches();
    }

    static boolean isLastNamelValid(String lastName) {
        Pattern patternLastName = Pattern.compile(FIRST_LAST_NAME_PATTERN);
        Matcher matcherLastName = patternLastName.matcher(lastName);
        return matcherLastName.matches();
    }

    static {
        SCANNER = new Scanner(System.in);
        EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,}$";
        FIRST_LAST_NAME_PATTERN = "^[a-zA-Z-]{3,}$";
    }
}
