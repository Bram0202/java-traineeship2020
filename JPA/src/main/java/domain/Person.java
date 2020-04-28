package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "persons")
@NamedQuery(name = "selectAll", query = "select p from Person p")
public class Person extends AbstractEntity {

    private String name;
    private int age;
    private int balance = 0;

    @OneToOne(cascade = ALL)
    private Education currentEducation;

    @OneToMany(cascade = ALL)
    private List<Address> address = new ArrayList<>();

    @ManyToMany(cascade = MERGE)
    private List<Subject> subjects = new ArrayList<>();

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
        return "Person{ name= " + name + ", age= " + age + ", balance= " + balance + " }";
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setSubjects(Subject subject) {
        this.subjects.add(subject);
    }
}
