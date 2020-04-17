package homework.h9;

import homework.h7.Gender;
import homework.h7.Person;

public class App {
    public static void main(String[] args) throws Throwable {
        new App();
    }

    App () throws Throwable {
        Person iris = new Person("Iris", Gender.FEMALE, 19);
        System.out.println("start");
        iris.finalize();
        System.gc();
        System.out.println("done");
        System.out.println(iris.toString());
    }

    private static void f() throws Throwable
    {
        Person iris = new Person("Iris", Gender.FEMALE, 19);
        iris.finalize();
    }
}
