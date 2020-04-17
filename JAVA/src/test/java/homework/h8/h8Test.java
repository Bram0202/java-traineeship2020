package homework.h8;

import homework.h7.Gender;
import homework.h7.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class h8Test {

    Person iris, jan, jan2;

    @BeforeEach
    void init() {
        iris = new Person("Iris", 18);
        jan = new Person("Jan", Gender.MALE, 40);
        jan2 = new Person("Jan", Gender.MALE, 40);

    }

    @Test
    void personCopyIsEqualTest() {
        // given
        // when
        Person copyOfIris = iris;

        // then
        assertTrue(iris.equals(copyOfIris));
    }

    @Test
    void personDiffGenderCopyIsEqualTest() {
        // given
        Person copyOfIris = iris;

        // when
        copyOfIris.setGender(Gender.FEMALE);

        // then
        assertTrue(iris.equals(copyOfIris));
    }

//    @Test
//    void equalAgeBeforeChangeNotEqualsAfterTest() {
//        // given
//        Person copyOfIris = iris;
//
//        // when
//        try {
//            iris.setAge(22);
//        } catch (PersonDiedException e) {
//            System.out.println(e);
//        }
//
//        // then
//        assertTrue(iris.equals(copyOfIris));
//    }

    @Test
    void diffPersonsAreNotEqualsTest() {
        // when
        Person copyOfIris = iris;

        // then
        assertFalse(iris.equals(jan));
        assertFalse(jan2.equals(iris));
        assertFalse(copyOfIris.equals(jan));
        assertTrue(iris.equals(copyOfIris));
    }

    @Test
    void diffPersonObjectsButEqualValuesTest() {
        assertTrue(jan.equals(jan2));
    }

    @Test
    void toStringOutputTest() {
        // when
        String expected = iris.getName() + "(" + iris.getAge() + ") is " + iris.getGender();

        // then
        assertEquals("Iris(18) is UNKNOWN", iris.toString());
        assertEquals(expected, iris.toString());
    }

//    @Test
//    public void getClassInfo() {
//        Method[] declaredMethods = Person.class.getDeclaredMethods();
//        for (Method method : declaredMethods) {
//            System.out.println(method);
//        }
//    }
}
