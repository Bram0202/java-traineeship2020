package homework.h10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person target;

    @BeforeEach
    void setup() {
        target = new Person("TestPerson", Gender.UNKNOWN, 0);
    }

    @Test
    void greetIsCorrect() {
        // given
        String expectedTestOutput = "Hello, my name is TestPerson. Nice to meet you!";

        // when
        String testOutput = target.greet();

        target.setName("Nobody");
        String testOutput2 = target.greet();

        // then
        assertEquals(expectedTestOutput, testOutput);
        assertNotEquals(expectedTestOutput, testOutput2);
    }

    @Test
    void setPersonsAge() throws PersonDiedException, PersonsAgeBelowZeroException {
        // when
        target.setAge(10);
        int testOutput = target.getAge();

        // then
        assertEquals(10, testOutput);
    }

    @Test
    void personsAgeCantBeBelowZero() {
        assertThrows(PersonsAgeBelowZeroException.class, () -> target.setAge(-10));
    }

    @Test
    void personsAgeCantBeOverMaxAge() throws PersonDiedException, PersonsAgeBelowZeroException {
        // given
        // that targets age is initialized at 0.

        // when
        target.setAge(130);
        int testOutput130 = target.getAge();

        // then
        assertEquals(130, testOutput130);
        assertThrows(PersonDiedException.class, () -> target.setAge(131));
    }

    @Test
    void overridenEqualsWorksAsExpected() {
        // given
        // that samePerson is exactly the same as target.
        Person samePerson = new Person("TestPerson", Gender.UNKNOWN, 0);

        // Different persons.
        Person diffNamePerson = new Person("NotTestPerson", Gender.UNKNOWN, 0);
        Person diffGenderPerson = new Person("TestPerson", Gender.FEMALE, 0);
        Person diffAgePerson = new Person("TestPerson", Gender.UNKNOWN, 10);
        Person totalDiffPerson = new Person("NoName", Gender.MALE, 73);

        // then
        assertEquals(samePerson, target);
        assertNotEquals(diffNamePerson, target);
        assertNotEquals(diffGenderPerson, target);
        assertNotEquals(diffAgePerson, target);
        assertNotEquals(totalDiffPerson, target);
    }

    @Test
    void equalsAndHashCodeAreBothOverwritten() {
        // TODO: Een test proberen te schrijven die faalt als hashCode of equals niet beide zijn overriden.
    }

    @Test
    void haveBirthdayExceptionTest() throws PersonDiedException, PersonsAgeBelowZeroException {
        // when
        target.setAge(130);

        // then
        assertThrows(PersonDiedException.class, () -> target.haveBirthday());
    }

}