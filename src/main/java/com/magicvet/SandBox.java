package main.java.com.magicvet;

import main.java.com.magicvet.comparator.PetAgeComparator;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandBox {

    public static void main(String[] args) {
        System.out.println("Sorting dogs by Size: ");

        Dog[] dogs = {
                new Dog(Dog.Size.M),
                new Dog(Dog.Size.S),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XS),
                new Dog(Dog.Size.S),
                new Dog(Dog.Size.L)
        };
        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });

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
