package org.example;

public class Person {
    private String name;//required
    private String surname;//required
    private int age;//optional, изменяется только на +1 через метод happyBirthday()
    private String currentAddress;//optional, boolean hasAddress()

    public boolean hasAge() {
        return this.age != 0;
    }

    public boolean hasAddress() {
        return this.currentAddress != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public void happyBirthday() {
        this.age++;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + age + " " + currentAddress;
    }

    public static class PersonBuilder {
        private final Person newPerson;

        public PersonBuilder() {
            newPerson = new Person();
        }

        public PersonBuilder setName(String name) {
            newPerson.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            newPerson.surname = surname;
            return this;
        }

        public PersonBuilder setAge(int age) {
            if (!newPerson.hasAge() && age > 0) {
                newPerson.age = age;
                return this;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public PersonBuilder setAddress(String address) {
            newPerson.currentAddress = address;
            return this;
        }

        public Person build() {
            if (newPerson.name != null || newPerson.surname != null) {
                return newPerson;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder pbChild = new PersonBuilder();

        pbChild.setSurname(getSurname());
        pbChild.setAddress(getCurrentAddress());


        return pbChild;


    }
}

