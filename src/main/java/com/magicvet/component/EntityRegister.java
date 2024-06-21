package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityRegister {

    private final ClientService clientService = new ClientService(); //переробив на final
    private final PetService petService = new PetService(); //переробив на final
    private static final String ANSWER_ADD_YES = "Yes"; //переробив на final
    private static final String ANSWER_ADD_NO = "No"; //переробив на final

    public void registerClients() {
        List<Client> clients = new ArrayList<>();

        String message = "Do you like to register more clients? (Yes / No): ";
        do {
            Optional<Client> client = addClient();
            client.ifPresent(clients::add);

        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> clientsByLocation = clients.stream()
                .collect(Collectors.groupingBy(Client::getLocation));
        printClients(clientsByLocation);
    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for (Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()) {
            String content =  "\nLocation: " + clients.getKey()
                             +"\nClients (" + clients.getValue().size() + "):"
                             +"\t" + clients.getValue();

            System.out.println(content);
        }
    }


    private Optional<Client> addClient() {
        Optional<Client> client = clientService.registerNewClient();
        client.ifPresent(this::registerPets);

        return client;
    }

    private void registerPets(Client client) {
        String message = "Would you like to add more pets? (Yes / No): ";
        do {
            addPet(client);
            System.out.println(client); //вивід Клиєнта
        } while (verifyRepeating(message));
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

    private boolean verifyRepeating(String message) {
        System.out.print(message);

        String ANSWEAR = Main.SCANNER.nextLine().toLowerCase(); //перетворюємо в нижній регістр (.toLowerCase())
        if (ANSWEAR.equalsIgnoreCase(ANSWER_ADD_YES)) {
            return true;
        } else if (ANSWEAR.equalsIgnoreCase(ANSWER_ADD_NO)) {
            return false;
        } else {
            System.out.println("Incorrect answer. Please make the right choice (Yes / No): ");
            return verifyRepeating(message);
        }
    }
}
