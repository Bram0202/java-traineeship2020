package labs.h6;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Sudoku {
    public static void main(String[] args) {
        new Sudoku();
    }

    Sudoku() {
        int[] inputGetallen = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] shuffledArr = shuffleArray(inputGetallen);
        printSudoku(arrToNestedArr(shuffledArr));
    }

    int[][] arrToNestedArr(int[] inputArr) {
        int[][] sudoku = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int counter = 0;

        // input -> sudoku
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                sudoku[i][j] = inputArr[counter];
                counter++;
            }
        }
        return sudoku;
    }

    void printSudoku(int[][] sudoku) {
        int counter = 0;

        for (int[] ints : sudoku) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
                counter++;

                if (counter % 3 == 0 && counter != 0) {
                    System.out.println("");
                }
            }
        }
    }

    int[] shuffleArray(int[] inputArr) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random random = ThreadLocalRandom.current();
        //Random random = new Random();

        for (int achterstePositie = inputArr.length - 1; achterstePositie > 0; achterstePositie--) {
            // Random index getal om een getal op die positie in de array weg te halen.
            int shuffleGetal = random.nextInt(achterstePositie + 1);

            // Simple swap
            int temp = inputArr[shuffleGetal]; // tijdelijke storage van het getal dat wordt geshuffled.
            inputArr[shuffleGetal] = inputArr[achterstePositie]; // Zet het achterste getal op de plek van het te shufflen getal.
            inputArr[achterstePositie] = temp; // Zet het geshufflede getal op de plek van de achterste waarde.
        }

        return inputArr;
    }


}
