package practice11;

import static java.util.Objects.nonNull;

public class Person {
    private String name;
    private int age;
    private int id;

    public Person(String name, int id, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", name, age);
    }

    @Override
    public boolean equals(Object targetPerson) {
        return nonNull(targetPerson) && id == ((Person) targetPerson).getId();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}