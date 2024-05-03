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

                System.out.print("Would you like to add a pet? (Yes / No): "); // функціонал перевірки необхідності клієнта у реєстрації улюбленця одразу.
                String ANSWEAR = Main.SCANNER.nextLine().toLowerCase(); //перетворюємо в нижній регістр (.toLowerCase())

                //No
                if (ANSWEAR_ADD_PET_NO.equalsIgnoreCase(ANSWEAR)) { // Якщо No, не додаємо Pet (перевіряємо без урахування регістру IgnoreCase)
                    System.out.println("No pet added. You can add it at any time in the future.");
                }

                //Yes
                if (ANSWEAR_ADD_PET_YES.equalsIgnoreCase(ANSWEAR)) { // Якщо так, додаємо Pet (перевіряємо без урахування регістру IgnoreCase)
                    System.out.println("Adding a new pet."); //=> додаємо Pet

                    Pet pet = petService.registerNewPet();// виклик метода рєєстрації NewPet
                    if ( (pet != null)) {
                        client.setPet(pet);
                        pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                        System.out.println("Pet has been added.");
                    }

                    System.out.println(client); //вивід Клиєнта
                }
            }
        }
    }
}
