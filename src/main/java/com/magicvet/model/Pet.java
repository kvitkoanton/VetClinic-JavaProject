package main.java.com.magicvet.model;

import java.util.Objects;

public class Pet { //was abstract

    private String type;
    private String sex;
    private int age;
    private String name;
    private String ownerName;
    private HealthState healthState;

    public Pet(){}

    public Pet(String name, int age, String sex, HealthState healthState) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.healthState = healthState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName)
                && Objects.equals(healthState,pet.healthState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName, healthState);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public HealthState getHealthState() {
        return healthState;
    }

    public void setHealthState(HealthState healthState) {
        this.healthState = healthState;
    }

    public enum HealthState {
        HEALTHY(8,"the animal has no visible or known health problems."), // (Здоровий) – тварина не має видимих чи відомих проблем зі здоров'ям.
        SICK(4, "the animal is sick or has medical problems."), // (Хворий) - тварина хворіє або має медичні проблеми.
        INJURED(3,"the animal was injured."), // (Травмований) - тварина отримала травму.
        RECOVERING(6,"the animal is in the process of recovery from illness or injury."), //(Одужує) - тварина знаходиться в процесі одужання після хвороби або травми.
        CRITICAL(1,"the animal is in critical condition and needs urgent medical care."), //(Критична) - тварина в критичному стані і потребує невідкладної медичної допомоги.
        CHRONIC(7,"the animal suffers from a chronic disease that requires constant care."), // (Хронічне) - тварина страждає від хронічного захворювання, яке потребує постійного догляду.
        UNDER_OBSERVATION(5,"the animal is being observed by a veterinarian, but does not yet have a definitive diagnosis."), //(Під спостереженням) - тварина спостерігається ветеринаром, але поки що не має остаточного діагнозу.
        DECEASED(0,"the animal has died (this status can be used to archive animal data)."), //(Померла) - тварина померла (цей статус можна використовувати для архівації даних про тварин).
        UNKNOWN(2,"the state of health of the animal is not determined."); //(Невідоме) – стан здоров'я тварини не визначено.

        private final int value;
        private final String note;

        HealthState (int value, String note){
            this.value = value;
            this.note = note;
        }

        public int getValue() {
            return value;
        }

        public String getNote() {
            return note;
        }
    }
}

