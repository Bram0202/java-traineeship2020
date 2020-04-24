package domain;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@NamedQuery(name = "selectAll", query = "select p from Person p")
public class Person {
    @Id @GeneratedValue
    private int id;

    private String name;
    private int age;
    private int balance = 0;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Subject subject;

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

    public int getId() { return id; }

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

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
