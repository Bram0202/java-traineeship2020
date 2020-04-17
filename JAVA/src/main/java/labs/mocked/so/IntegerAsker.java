package labs.mocked.so;

import java.io.PrintStream;
import java.util.Scanner;

public class IntegerAsker {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintStream out = System.out;

    public static void main(String[] args) {
        new IntegerAsker();
    }


    public IntegerAsker() {
            int i = getBoundIntegerFromUser(this);
    }

    public int ask(String message ){
        out.println(message);
        return scanner.nextInt();
    }


    public static int getBoundIntegerFromUser(IntegerAsker asker) {
        int input = asker.ask("Give a number between 1 and 10");
        while (input < 1 || input > 10)
            input = asker.ask("Wrong number, try again.");
        return input;
    }

}

