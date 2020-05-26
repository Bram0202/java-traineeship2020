package first.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private String firstname;
    private String lastname;
    private int yearOfBirth;

    public String getLastname() {
        return lastname;
    }
}
