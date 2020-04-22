package domain;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    @Id @GeneratedValue
    private int id;

    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{ name= " + name + ", age= " + age + "}";
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public int getAge() { return age; }

}
