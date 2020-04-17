package homework.h9;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    Main() {
        stringIsNull(null);
    }

    void stringIsNull(String s) {
        if (s == null) {
            System.out.println("Geen null!");
        }
    }
}
