package models;

public abstract class Person {
    private static int idCounter = 1;
    private final int id;
    private final String name;

    public Person(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}