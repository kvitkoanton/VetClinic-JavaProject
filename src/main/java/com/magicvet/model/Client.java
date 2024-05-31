package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy"); // залишив такий шаблон як у классі Pet, бо мені він подобається

    private String firstName;
    private String lastName;
    private String email;
    private List<Pet> pets = new ArrayList<>();
    private final LocalDateTime registrationDateTimeClient = LocalDateTime.now();
    private Location location;


    @Override
    public String toString() {
        return "\nClient {"
                + "\nfirstName = " + getFirstName()
                + ", lastName = " + getLastName()
                + ", E-mail = " + getEmail()
                + ", location = " + getLocation()
                + ", registrationDateTimeClient = " + getRegistrationDateTimeClient().format(FORMATTER)
                + ", pets:\n" + getPets()
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(registrationDateTimeClient, client.registrationDateTimeClient)
                && Objects.equals(pets, client.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, registrationDateTimeClient, pets);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public LocalDateTime getRegistrationDateTimeClient() {
        return registrationDateTimeClient;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public enum Location {
        KYIV, LVIV, ODESA

    }
}

