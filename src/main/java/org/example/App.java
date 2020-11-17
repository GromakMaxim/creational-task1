package org.example;

public class App {
    public static void main(String[] args) {
        Person mom = new Person.PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(1)
                .setAddress("Сидней")
                .build();

        mom.happyBirthday();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        son.happyBirthday();

        System.out.println("У " + mom + " есть сын, " + son);

        // Не хватает обяхательных полей
        new Person.PersonBuilder().build();

        // Возраст недопустимый
        new Person.PersonBuilder().setAge(-100).build();

    }
}
