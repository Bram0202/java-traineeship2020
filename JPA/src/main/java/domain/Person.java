package domain;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    @Id @GeneratedValue
    private int id;

    private String name;
    private int age;
    private int balance = 0;

    public Person() {}

    public Person(String name, int age) {
        this(name, age, 0);
    }

    public Person(String name, int age, int balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Person{ name= " + name + ", age= " + age + "}";
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public int getAge() { return age; }

}
