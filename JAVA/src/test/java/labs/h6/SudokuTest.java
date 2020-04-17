package labs.h6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class SudokuTest {
    private Sudoku target;

    @BeforeEach
    void init() {
        target = new Sudoku();
    }

    @Test
    void LengteVanArrayBlijftGelijkTest() {
        // given
        int[] inputGetallen = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // when
        int[] testOutput = target.shuffleArray(inputGetallen);

        // then
        Assertions.assertEquals(9, testOutput.length);
    }

//    @Test
//    void inputEnOutputZijnNietGelijkTest() {
//        // given
//        int[] inputArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//
//        // when
//        int[] testOutput = target.shuffleArray(inputArr);
//
//        // then
//        Assertions.assertNotSame(inputArr, testOutput);
//    }
}
