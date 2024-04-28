package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

public class PetService {

    private static final String DOG_TYPE = "dog";

    public Pet registerNewPet() {
        Pet pet = new Pet();
        System.out.print("Type (dog / cat / other): ");

        String type = Main.SCANNER.nextLine().toLowerCase();  //перетворюємо в нижній регістр ".toLowerCase()")"

        if (DOG_TYPE.equalsIgnoreCase(type)) { //  якщо ТИП собака (перевіряємо без урахування регістру "IgnoreCase")
            pet = buildDog();
        }else {
            pet = buildPet(type);
        }

        return pet;
    }

    private Dog buildDog() {
        Pet pet = buildPet(DOG_TYPE);
        Dog dog = petToDog(pet);

        System.out.print("Size (XS / S / M / L / XXL): ");
        dog.setSize(Main.SCANNER.nextLine().toUpperCase()); // перетворюємо в верхній регістр

        return dog;
    }

    private Dog petToDog(Pet pet) {
        Dog dog = new Dog();
        dog.setAge(pet.getAge());
        dog.setName(pet.getName());
        dog.setSex(pet.getSex());

        return dog;
    }

    private Pet buildPet(String type) {
        Pet pet = new Pet();
        pet.setType(type);

        System.out.print("Sex (male / female): ");
        pet.setSex(Main.SCANNER.nextLine());

        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextLine());

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());

        return pet;

    }
}
