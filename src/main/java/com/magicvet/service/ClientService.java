package main.java.com.magicvet.service;
import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,}$";
    private static String FIRST_LAST_NAME_PATTERN = "^[a-zA-Z-]{3,}$";


    public Client registerNewClient() {
        Client client = null;

        System.out.println("Please provide client details.");
        System.out.print("E-Mail: ");
        String email = Main.SCANNER.nextLine();
        if (!isEmailValid(email)) {
            System.out.println("Providet E-Mail is invalid");
        } else {
            System.out.print("First name: ");
            String firstName = Main.SCANNER.nextLine();
            if (!isFirstNamelValid(firstName)) {
                System.out.println("Providet First name is invalid");
            } else {
                System.out.print("Last name: ");
                String lastName = Main.SCANNER.nextLine();
                if (!isLastNamelValid(lastName)) {
                    System.out.println("Providet Last name is invalid");
                } else {
                    client = buildClient(email, firstName, lastName);
                    System.out.println("New client: " + client.getFirstName()
                            + " " + client.getLastName()
                            + " (" + client.getEmail() + ")");
                }
            }
        }
        return client;
    }

    private static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        return client;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isFirstNamelValid(String firstName) {
        Pattern patternFirstName = Pattern.compile(FIRST_LAST_NAME_PATTERN);
        Matcher matcherFirstName = patternFirstName.matcher(firstName);
        return matcherFirstName.matches();
    }

    private static boolean isLastNamelValid(String lastName) {
        Pattern patternLastName = Pattern.compile(FIRST_LAST_NAME_PATTERN);
        Matcher matcherLastName = patternLastName.matcher(lastName);
        return matcherLastName.matches();
    }

}
