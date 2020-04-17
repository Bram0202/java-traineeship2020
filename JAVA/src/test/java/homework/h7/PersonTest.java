package homework.h7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    private Person p, p1, p2, p3;

    @Test
    void testPerson() {
        // given
        p = new Person("Jan", 45);

        // when
        System.out.println(p.getGender());
        // then
        assertEquals(Gender.UNKNOWN, p.getGender());

        // when
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        // then
        assertEquals(Gender.MALE, p.getGender());

        // when
        p.haveBirthday();
        System.out.println(p.getAge());
        // then
        assertEquals(46, p.getAge());

        // when
        System.out.println(Person.numberOfPossibleGenders);
        assertEquals(3, Person.numberOfPossibleGenders);
    }

    @Test
    void personDiedTest() {
        // given
        p1 = new Person("Jacob", 129);
        p2 = new Person("Kees", 130);
        p3 = new Person("Bertus", 131);

        // when
        System.out.println("Age p1: " + p1.getAge());
        p1.haveBirthday();
        System.out.println("Age p1: " + p1.getAge());
        // then
        assertEquals(130, p1.getAge());

        // when
        PersonDiedException e2 = assertThrows(PersonDiedException.class, () -> p2.haveBirthday());
        // then
        String message2 = e2.getMessage();
        assertEquals("Jan has DIED!", message2);

        // when
        PersonDiedException e3 = assertThrows(PersonDiedException.class, () -> p3.haveBirthday());
        // then
        String message3 = e3.getMessage();
        assertEquals("Bertus has DIED!", message3);

    }
}


