package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PetService {
    private static final String SIZE_PATTERN = "^(XS|S|M|L|XL|XXL)$"; // шаблон для розміру
    private static final String SEX_PATTERN = "^(male|female)$"; // шаблон для стать тварини
    private static final String NAME_PATTERN = "^[A-Z][a-z]*$"; // шаблон Ім'я
    private static final String DOG_TYPE = "dog";

    public Pet registerNewPet() {
        Pet pet = new Pet();
        System.out.print("Type (dog / cat / other): ");

        String type = Main.SCANNER.nextLine().toLowerCase();  //перетворюємо в нижній регістр ".toLowerCase()")"

        if (DOG_TYPE.equalsIgnoreCase(type)) { //  якщо ТИП собака (перевіряємо без урахування регістру "IgnoreCase")
            pet = buildDog();
        } else {
            pet = buildPet(type);
        }
        return pet;
    }

    private Dog buildDog() {
        Pet pet = buildPet(DOG_TYPE);
        Dog dog = petToDog(pet);

        System.out.print("Size (XS / S / M / L / XL / XXL): ");
        dog.setSize(Main.SCANNER.nextLine().toUpperCase()); // перетворюємо в верхній регістр
        while (!isSizeValid(dog.getSize())) {
            System.out.print("Invalid input. Please enter one of the following sizes (XS, S, M, L, XL, XXL): ");
            dog.setSize(Main.SCANNER.nextLine().toUpperCase());
        }
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
        while (!isSexValid(pet.getSex())) {
            System.out.print("Invalid input. Please enter one of the following sexes (male / female): ");
            pet.setSex(Main.SCANNER.nextLine());
        }

        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextLine());

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());
        while (!isNameValid(pet.getName())) {
            System.out.print("Invalid input. Please enter the Name in following format (The first letter is capital, the rest are small): ");
            pet.setName(Main.SCANNER.nextLine());
        }
        return pet;
    }

    private static boolean isSizeValid(String size) {
        Pattern patternSize = Pattern.compile(SIZE_PATTERN, Pattern.CASE_INSENSITIVE); // шаблон для Size без регістра
        Matcher matcherSize = patternSize.matcher(size);
        return matcherSize.matches();
    }
    private static boolean isSexValid(String sex) {
        Pattern patternSex = Pattern.compile(SEX_PATTERN, Pattern.CASE_INSENSITIVE); // шаблон для статі тварини без регістра
        Matcher matcherSex = patternSex.matcher(sex);
        return matcherSex.matches();
    }
    private static boolean isNameValid(String name) {
        Pattern patternName = Pattern.compile(NAME_PATTERN); // шаблон для Ім'я
        Matcher matcherName = patternName.matcher(name);
        return matcherName.matches();
    }

}