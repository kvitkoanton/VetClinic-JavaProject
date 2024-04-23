package main.java.com.magicvet.component;
import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

public class ApplicationRunner {

    private ClientService clientService = new ClientService();
    private PetService petService = new PetService();

    private static String ANSWEAR_ADD_PET_YES = "Yes";
    private static String ANSWEAR_ADD_PET_NO = "No";



    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) { // Если Client не null

                System.out.println("Would you like to add a pet? (Yes / No)"); // функціонал перевірки необхідності клієнта у реєстрації улюбленця одразу.
                String ANSWEAR = Main.SCANNER.nextLine();
                //No
                if (ANSWEAR_ADD_PET_NO.equals(ANSWEAR)) { // Якщо ні, додаємо Pet
                    System.out.println("No pet added. You can add it at any time in the future.");
                }

                //Yes
                if (ANSWEAR_ADD_PET_YES.equals(ANSWEAR)) { // Якщо так, додаємо Pet
                    System.out.println("Adding a new pet."); //=> додаємо Pet

                    Pet pet = petService.registerNewPet();// виклик метода рєєстрації NewPet
                    client.setPet(pet);
                    pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                    System.out.println("Pet has been added");
                }
            }
        }
    }
}
