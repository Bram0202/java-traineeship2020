package domain;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id @GeneratedValue
    private int id;

    private String name;

    public Subject() {}

    public Subject(String name) { this.name = name; }

    public String getName() {
        return name;
    }
}

