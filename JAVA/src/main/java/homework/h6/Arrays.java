package homework.h6;

public class Arrays {
    public static void main(String[] args) {
        new Arrays();
    }

    Arrays() {
        // Opdracht 1 en 2.
        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;

        // Opdracht 1.
        //System.out.println(row[2]); // 4 | 4
        // Opdracht 2.
        //System.out.println(row[4]); // OoBE | OoBE

        // Opdracht 3.
        long[] longArr = {1, 2, 3, 4};
        longArr = doubleLongArraysLength(longArr);
        for (long l : longArr) {
            System.out.println(l);
        }

        // Opdracht 4.
        long[] multiplyArr = {1, 2, 3, 4};
        multiply(multiplyArr, 2);
        for (long l : multiplyArr) {
            System.out.println(l);
        }

        // Opdracht 5.
        int n = 93;
        long[] fibo = fiboArray(n);
        for (long l : fibo) {
            System.out.println(l);
        }

    }


    // Opdracht 3.
    long[] doubleLongArraysLength(long[] input) {
        long[] doubledCopy = new long[(input.length * 2)];

        for (int i = 0; i < input.length; i++) {
            doubledCopy[i] = input[i];
        }
        return doubledCopy;
    }

    // Opdracht 4.
    void multiply(long[] input, int multiplier) {
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i] * multiplier;
        }
    }

    // Opdracht 5.
    long[] fiboArray(int n) {
        long[] arr = new long[n];

        long fOne = 0;
        long fTwo = 1;
        long sum = fOne + fTwo;

        arr[0] = fOne;
        arr[1] = fTwo;

        for (int i = 2; i < n; i++) {
            arr[i] = sum;
            fOne = fTwo;
            fTwo = sum;
            sum = fOne + fTwo;
        }

        return arr;
    }
}
