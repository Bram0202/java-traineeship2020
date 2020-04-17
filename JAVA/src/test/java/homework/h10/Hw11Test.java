package homework.h10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Hw11Test {

    Person target;

    @BeforeEach
    void setup() {
        target = new Person("TestPerson");
    }

    @Test
    void anonymousMethodsGreetIsReachable() {
        assertEquals("Sub is the best.", target.createSubHuman().greet());
    }
}
