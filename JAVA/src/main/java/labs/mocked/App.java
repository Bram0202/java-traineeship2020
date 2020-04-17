package labs.mocked;

public class App {

    public static void main(String[] args) {
        new App();
    }

    App() {
        System.out.println(UserInputToAllCaps());
    }

    public static String UserInputToAllCaps() {
        CustomScanner scanner = new CustomScanner();
        String input = scanner.nextLine("Voer tekst in..");
        return input.toUpperCase();
    }
}
