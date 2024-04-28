package main.java.com.magicvet.model;

import java.util.Objects;

public class Client {
    private String FirstName;
    private String LastName;
    private String email;
    private Pet pet;

    @Override
    public String toString() {
        return "Client {"
                + "\n\tfirstName = " + FirstName
                + ", lastName = " + LastName
                + ", E-mail = " + email
                + ",\n\tpet = " + pet
                + "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(FirstName, client.FirstName)
                && Objects.equals(LastName, client.LastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pet, client.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, email, pet);
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getLastName() {
        return LastName;
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
}

