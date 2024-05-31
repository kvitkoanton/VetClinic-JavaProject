package main.java.com.magicvet.service;
import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,}$";
    private static final String FIRST_LAST_NAME_PATTERN = "^[a-zA-Z-]{3,}$";
    private static final String LOCATION_PATTERN = "^(KYIV|LVIV|ODESA)$";

    public Client registerNewClient() {
        Client client = null;
        String email;
        String firstName;
        String lastName;
        String location;

        System.out.println("Please provide client details.");
        System.out.print("E-Mail: ");
        email = Main.SCANNER.nextLine();

        while (!isEmailValid(email)) {
            System.out.print("Providet E-Mail is invalid, please indicate in the following format (xxx.xxx@xxx.xxx): ");
            email = Main.SCANNER.nextLine();
        }

        System.out.print("First name: ");
        firstName = Main.SCANNER.nextLine();

        while (!isFirstNameValid(firstName)) {
            System.out.print("Provided First name is invalid, please indicate the First name in the following format (a-zA-Z, min 3 characters): ");
            firstName = Main.SCANNER.nextLine();
        }

        System.out.print("Last name: ");
        lastName = Main.SCANNER.nextLine();

        while (!isLastNameValid(lastName)){
            System.out.print("Provided Last name is invalid, please indicate the Last name in the following format (a-zA-Z, min 3 characters): ");
            lastName = Main.SCANNER.nextLine();
        }

        System.out.print("Enter Location: ");
        location = Main.SCANNER.nextLine().toUpperCase();
        while (!islocationValid(location)) {
            System.out.print("Providet Location is invalid, please choose 3 cities (KYIV|LVIV|ODESA): ");
            location = Main.SCANNER.nextLine().toUpperCase();
        }

        client = buildClient(email, firstName, lastName, location);
        System.out.println("New client: "   + client.getFirstName() + " "
                                            + client.getLastName() + " with E-Mail: "
                                            + client.getEmail() + " in "
                                            + client.getLocation() + " has been created)");
        return client;
    }

    private static Client buildClient(String email, String firstName, String lastName, String location) {
        Client client = new Client();
        client.setEmail(email); //було тільки так
        client.setFirstName(firstName); //було тільки так
        client.setLastName(lastName); //було тільки так
        client.setLocation(Client.Location.valueOf(location));
        return client;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isFirstNameValid(String firstName) {
        Pattern patternFirstName = Pattern.compile(FIRST_LAST_NAME_PATTERN);
        Matcher matcherFirstName = patternFirstName.matcher(firstName);
        return matcherFirstName.matches();
    }

    private static boolean isLastNameValid(String lastName) {
        Pattern patternLastName = Pattern.compile(FIRST_LAST_NAME_PATTERN);
        Matcher matcherLastName = patternLastName.matcher(lastName);
        return matcherLastName.matches();
    }

    private static boolean islocationValid(String location) {
        Pattern patternLocation = Pattern.compile(LOCATION_PATTERN);
        Matcher matcherLocation = patternLocation.matcher(location);
        return matcherLocation.matches();
    }

}
