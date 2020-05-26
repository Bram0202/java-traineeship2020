package first.domain;

import java.util.Arrays;
import java.util.List;

public class Values {

    public static Student BAKX =
            Student.builder()
                    .lastname("Bakx")
                    .yearOfBirth(1997)
                    .build();

    public static Student DELANGE =
            Student.builder()
                    .lastname("De Lange")
                    .yearOfBirth(1994)
                    .build();

    public static List<Student> STUDENTS = Arrays.asList(BAKX, DELANGE);
}
