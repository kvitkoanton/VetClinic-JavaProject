package main.java.com.magicvet;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandBox {

    public static void main(String[] args) {

        Dog[] dogs = {
                new Dog(Dog.Size.M),
                new Dog(Dog.Size.S),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XS),
                new Dog(Dog.Size.S),
                new Dog(Dog.Size.L)
        };

        System.out.println("Sorting dogs by Size: ");
        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });

        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        Pet[] pets = {
                new Pet("Cat", "Chuck", 18, "male",Pet.HealthState.CHRONIC),
                new Pet("Cat", "Lacosta", 12, "female",Pet.HealthState.CRITICAL),
                new Pet("Cat", "Mercedes", 11, "female",Pet.HealthState.RECOVERING),
                new Pet("Cat", "Amily", 10, "female",Pet.HealthState.SICK),

        };

        System.out.println();
        System.out.println("Sorting Pets by Age: ");
        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for (Pet pet : pets) {
            System.out.println(pet.getName() + ", " + pet.getAge() + ", " + pet.getSex());
        }

        System.out.println();
        System.out.println("Sorting pets by HealthState: ");
        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getHealthState().getValue() - o2.getHealthState().getValue();
            }
        });
        for (Pet pet : pets) {
            System.out.println(pet.getHealthState().getValue() + ", " + pet.getName() + ", " + pet.getAge() + ", " + pet.getSex() + ", " + pet.getHealthState().getNote());
        };
        System.out.println("Pet " + new Pet());
        System.out.println("Cat " + new Cat());
        System.out.println("Dog " + new Dog());
    }
}
