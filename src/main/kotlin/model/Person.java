package model;

public class Person implements Kotliner {
    public String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String title() {
        return null;
    }
}
