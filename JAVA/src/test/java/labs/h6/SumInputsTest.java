package labs.h6;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumInputsTest {
    private SumInputs target;

    @BeforeEach
    void init() {
        target = new SumInputs();
    }

    @Test
    void sumOfInputTest() {
        // given
        int[] simpleTestInputs = {1, 2, 3};
        int[] negativeTestInputs = {-1, 2, -3, -10};
        int[] doubleZeroTestInputs = {0, -0};

        // when
        int simpleTestResults = target.sumOfInput(simpleTestInputs);
        int negativeTestResults = target.sumOfInput(negativeTestInputs);
        int doubleZeroTestResults = target.sumOfInput(doubleZeroTestInputs);

        // then
        assertEquals(6, simpleTestResults);
        assertEquals(-12, negativeTestResults);
        assertEquals(0, doubleZeroTestResults);
    }
}
