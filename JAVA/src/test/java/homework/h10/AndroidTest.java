package homework.h10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AndroidTest {

    Android target;

    @BeforeEach
    void setup() {
        target = new Android();
    }

    @Test
    void chargeAndroid() {
        // given
        // int level wordt geinitialiseerd op 43.

        // when
        int testOutput = target.charge(10);

        // then
        assertEquals(53, testOutput);
    }

    @Test
    void chargeAndroidWithZero() {
        // given
        // int level wordt geinitialiseerd op 43.

        // when
        int testOutput = target.charge(0);

        // then
        assertEquals(43, testOutput);

    }

    @Test
    void chargeAndroidverMaxLevel() {
        // given
        // int level wordt geinitialiseerd op 43.

        // when
        int testOutput = target.charge(58);
        int testOutput2 = target.charge(1000);

        // then
        assertEquals(100, testOutput);
        assertEquals(100, testOutput);
    }
}