package main.java.com.magicvet;

import main.java.com.magicvet.comparator.DogSizeComparator;
import main.java.com.magicvet.comparator.PetAgeComparator;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;

public class SandBox {

    public static void main(String[] args) {
        System.out.println("Sorting dogs by Size: ");

        Dog[] dogs = {
                new Dog(Dog.M),
                new Dog(Dog.S),
                new Dog(Dog.XL),
                new Dog(Dog.XL),
                new Dog(Dog.XS),
                new Dog(Dog.S),
                new Dog(Dog.L)
        };
        Arrays.sort(dogs, new DogSizeComparator());

        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        System.out.println();
        System.out.println("Sorting Pets by Age: ");
        Pet[] pets = {
                new Pet("Chuck", 18, "male"),
                new Pet("Lacosta", 12, "female"),
                new Pet ("Mersedec", 11, "female"),
                new Pet( "Amily", 10,"female")
        };
        Arrays.sort(pets, new PetAgeComparator());

        for (Pet pet : pets) {
            System.out.println(pet.getName() + ", " + pet.getAge() + ", " + pet.getSex());
        }
    }
}
