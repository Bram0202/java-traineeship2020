package labs.mocked;

import java.io.PrintStream;
import java.util.Scanner;

public class CustomScanner {
     private final Scanner scanner = new Scanner(System.in);
//     private final PrintStream out = System.out;

    public String nextLine() {
        return scanner.nextLine();
    }

    public String nextLine(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
   }
