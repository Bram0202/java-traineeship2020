package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAdderTest {

    StringAdder target;

    @BeforeEach
    void init() {
        target = new StringAdder();
    }

    @Test
    void whenInputIsZero() {
        // given init().

        // when
        int testOutputWhenInputIsOneZero = target.add("0");
        int testOutputWhenInputAreTwoZeros = target.add("0", "0");
        int testOutputWhenInputAreThreeZeros = target.add("0", "0", "0");
        int testOutputWhenInputAreManyZeros = target.add("0", "0", "0", "0", "0", "0", "0");

        // then
        assertEquals(0, testOutputWhenInputIsOneZero);
        assertEquals(0, testOutputWhenInputAreTwoZeros);
        assertEquals(0, testOutputWhenInputAreThreeZeros);
        assertEquals(0, testOutputWhenInputAreManyZeros);
    }

    @Test
    void whenInputIsNull() {
        // given init().

        // when
        int testOutput = target.add(null);
        int testOutputIsNullTwice = target.add(null, null);

        // then
        assertEquals(0, testOutput);
        assertEquals(0, testOutputIsNullTwice);
    }

    @Test
    void whenInputIsEmptyString() {
        // given init().

        // when
        int testOutputWhenInputIsOneEmptyString = target.add("");
        int testOutputWhenInputAreTwoEmptyStrings = target.add("", "");
        int testOutputWhenInputAreManyEmptyStrings = target.add("", "", "", "", "", "", "");
        int testOutputWhenInputIsMixedWithEmptyStrings1 = target.add("", "1");
        int testOutputWhenInputIsMixedWithEmptyStrings2 = target.add("1", "");
        int testOutputWhenInputIsMixedWithEmptyStrings3 = target.add("", "1", "", "", "");
        int testOutputWhenInputIsMixedWithEmptyStrings4 = target.add("1", "", "", "2", "3");

        // then
        assertEquals(0, testOutputWhenInputIsOneEmptyString);
        assertEquals(0, testOutputWhenInputAreTwoEmptyStrings);
        assertEquals(0, testOutputWhenInputAreManyEmptyStrings);
        assertEquals(1, testOutputWhenInputIsMixedWithEmptyStrings1);
        assertEquals(1, testOutputWhenInputIsMixedWithEmptyStrings2);
        assertEquals(1, testOutputWhenInputIsMixedWithEmptyStrings3);
        assertEquals(6, testOutputWhenInputIsMixedWithEmptyStrings4);
    }

    @Test
    void whenInputIsStringWithSpaces() {
        // given init().

        // when
        int testOutput = target.add(" ");

        // then
        assertEquals(0, testOutput);
    }

    @Test
    void whenInputIsOneDigit() {
        // given init().

        // when
        int testOutputWhenInputIsZero = target.add("0");
        int testOutputWhenInputIsOne = target.add("1");
        int testOutputWhenInputIsTwo = target.add("2");
        int testOutputWhenInputIs99 = target.add("99");

        // then
        assertEquals(0, testOutputWhenInputIsZero);
        assertEquals(1, testOutputWhenInputIsOne);
        assertEquals(2, testOutputWhenInputIsTwo);
        assertEquals(99, testOutputWhenInputIs99);
    }

    @Test
    void whenInputIsTwoDigits() {
        // given init().

        // when
        int testOutput1 = target.add("13");
        int testOutput2 = target.add("675");
        int testOutput3 = target.add("45646");

        // then
        assertEquals(13, testOutput1);
        assertEquals(675, testOutput2);
        assertEquals(45646, testOutput3);

    }

    @Test
    void whenInputHasNegativeNumbers() {
        // given init().

        // when
        int testOutputWhenInputIsMinusZero = target.add("-0");
        int testOutputWhenInputIsMinusOne = target.add("-1");
        int testOutputWhenInputIsMinus99 = target.add("-99");
        int testOutputWhenInputIsMinusFive = target.add("-5");
        int testOutputWhenAreTwoNumberBeneathZero = target.add("-5", "-100");
        int testOutputWhenMinusZeroPlusMinusSix = target.add("-0", "-6");
        int testOutputWhenMinusSixPlusMinusZero = target.add("-6", "-0");
        int testOutputWhenMinusZeroPlusMinusZero = target.add("-0", "-0");

        // then
        assertEquals(0, testOutputWhenInputIsMinusZero);
        assertEquals(-1, testOutputWhenInputIsMinusOne);
        assertEquals(-99, testOutputWhenInputIsMinus99);
        assertEquals(-5, testOutputWhenInputIsMinusFive);
        assertEquals(-105, testOutputWhenAreTwoNumberBeneathZero);
        assertEquals(-6, testOutputWhenMinusZeroPlusMinusSix);
        assertEquals(-6, testOutputWhenMinusSixPlusMinusZero);
        assertEquals(0, testOutputWhenMinusZeroPlusMinusZero);
    }

    @Test
    void whenTwoInputsAreGiven() {
        // given init().

        // when
        int testOutput1 = target.add("8", "1");
        int testOutput2 = target.add("0", "0");
        int testOutput3 = target.add("1", "1");
        int testOutput4 = target.add("0", "1");
        int testOutput5 = target.add("1", "0");

        // then
        assertEquals(9, testOutput1);
        assertEquals(0, testOutput2);
        assertEquals(2, testOutput3);
        assertEquals(1, testOutput4);
        assertEquals(1, testOutput5);
    }

    @Test
    void whenManyInputsAreGiven() {
        // given init().

        // when
        int testOutput1 = target.add("8", "1", "23");
        int testOutput2 = target.add("0", "1", "-1");
        int testOutput3 = target.add("1", "1", "1", "1", "1");
        int testOutput4 = target.add("-0", "1", "2", "3");
        int testOutput5 = target.add("1", "0", "1", "0", "1", "0");

        // then
        assertEquals(32, testOutput1);
        assertEquals(0, testOutput2);
        assertEquals(5, testOutput3);
        assertEquals(6, testOutput4);
        assertEquals(3, testOutput5);
    }

    @Test
    void whenInputIsNotNumber() {
        assertThrows(NumberFormatException.class, () -> target.add("a"));
        assertThrows(NumberFormatException.class, () -> target.add("abc"));
        assertThrows(NumberFormatException.class, () -> target.add("!"));
        assertThrows(NumberFormatException.class, () -> target.add("NINE"));
        assertThrows(NumberFormatException.class, () -> target.add("0", "'.[]"));
        assertThrows(NumberFormatException.class, () -> target.add("RUN", "5" ));
    }

    @Test
    void whenInputIsNewLineSeparated() {
        // given init().

        // when
        int testOutput1 = target.add("1", "\n2", "3");
        int testOutput2 = target.add("1\n", "2", "3");

        // then
        assertEquals(6, testOutput1);
        assertEquals(6, testOutput2);
    }

    @Test
    void whenInputHasStrangeDelimiters() {
        // given init().

        // when
        int testOutput1 = target.add(";\n1", ";2");
        int testOutput2 = target.add(";\n1", "2");
        int testOutput3 = target.add("1", ";2");

        // then
        assertEquals(3, testOutput1);
        assertEquals(3, testOutput2);
        assertEquals(3, testOutput3);
    }

}
