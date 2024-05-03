package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PetService {
    private static final String SIZE_PATTERN = "^(XS|S|M|L|XL|XXL)$"; // шаблон для розміру
    private static final String SEX_PATTERN = "^(male|female)$"; // шаблон для стать тварини
    private static final String NAME_PATTERN = "^[A-Z][a-z]*$"; // шаблон Ім'я
    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";

    public Pet registerNewPet() {
        Pet pet = null;
        System.out.print("Type (dog / cat): ");

        String type = Main.SCANNER.nextLine().toLowerCase();  //перетворюємо в нижній регістр ".toLowerCase()")"

        if (DOG_TYPE.equalsIgnoreCase(type) || CAT_TYPE.equalsIgnoreCase(type)) { //  якщо ТИП собака (перевіряємо без урахування регістру "IgnoreCase")
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type. Please choose one of the following types " + type);;
        }
        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equalsIgnoreCase(CAT_TYPE) ? new Cat() : new Dog();
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

        if (type.equalsIgnoreCase(DOG_TYPE)) {
            System.out.print("Size (XS / S / M / L / XL / XXL): ");
            ((Dog) pet).setSize(Main.SCANNER.nextLine().toUpperCase()); // перетворюємо в верхній регістр
            while (!isSizeValid(((Dog) pet).getSize())) {
                System.out.print("Invalid input. Please enter one of the following sizes (XS, S, M, L, XL, XXL): ");
                ((Dog) pet).setSize(Main.SCANNER.nextLine().toUpperCase());
            }
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