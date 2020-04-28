package domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "educations")
public class Education extends AbstractEntity {
    private String name;
    private String degree;
    private boolean isFinalized = false;

    public Education() {}
}
