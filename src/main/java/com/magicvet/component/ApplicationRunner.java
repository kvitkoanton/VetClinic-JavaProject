package main.java.com.magicvet.component;
import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

public class ApplicationRunner {

    private final ClientService clientService = new ClientService(); //переробив на final
    private final PetService petService = new PetService(); //переробив на final
    private static final String ANSWEAR_ADD_PET_YES = "Yes"; //переробив на final
    private static final String ANSWEAR_ADD_PET_NO = "No"; //переробив на final

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) { // Если Client не null
                registerPets(client);
                System.out.println(client); //вивід Клиєнта
            }
        }
    }

    private void registerPets(Client client) {
        String ANSWEAR = ANSWEAR_ADD_PET_YES;

        while (ANSWEAR.equalsIgnoreCase(ANSWEAR_ADD_PET_YES)) {
            addPet(client);
            System.out.print("Would you like to add more pets? (Yes / No): "); // функціонал перевірки необхідності клієнта у реєстрації наступного улюбленця.
            ANSWEAR = Main.SCANNER.nextLine().toLowerCase(); //перетворюємо в нижній регістр (.toLowerCase())

            while (!ANSWEAR.equalsIgnoreCase(ANSWEAR_ADD_PET_YES) && !ANSWEAR.equalsIgnoreCase(ANSWEAR_ADD_PET_NO)) {
                System.out.print("Please make the right choice (Yes / No): ");
                ANSWEAR = Main.SCANNER.nextLine().toLowerCase();
            }
        }

            // No
        if (ANSWEAR.equalsIgnoreCase(ANSWEAR_ADD_PET_NO)) {
            System.out.println("Thank you for registering your pet. You can add more pets at any time in the future.");
        }
    }

    private void addPet(Client client) {
        System.out.println("Adding a new pet."); //=> додаємо Pet

        Pet pet = petService.registerNewPet(); // виклик метода рєєстрації NewPet
        if ((pet != null)) {
            client.addPet(pet);
            pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
            System.out.println("Pet has been added.");
        }
    }
}
