package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Client {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"); // залишив такий шаблон як у классі Pet

    private String firstName;
    private String lastName;
    private String email;
    private Pet pet;
    private final LocalDateTime registrationDateTimeClient = LocalDateTime.now();


    @Override
    public String toString() {
        return "Client {"
                + "\n\tfirstName = " + getFirstName()
                + "\n\tlastName = " + getLastName()
                + "\n\tE-mail = " + getEmail()
                + "\n\tregistrationDateTimeClient = " + getRegistrationDateTimeClient().format(FORMATTER)
                + "\n\tpet = " + getPet()
                + "\n}";
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
                && Objects.equals(pet, client.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, registrationDateTimeClient, pet);
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

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public LocalDateTime getRegistrationDateTimeClient() {
        return registrationDateTimeClient;
    }
}

