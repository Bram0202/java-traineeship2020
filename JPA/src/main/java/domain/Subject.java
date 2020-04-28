package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject extends AbstractEntity {

    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Person> attendees = new ArrayList<>();

    public Subject() {}

    public Subject(String name) { this.name = name; }

    public String getName() {
        return name;
    }
}

