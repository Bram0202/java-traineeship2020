package homework.h13;

import homework.h10.*;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        House<Person> hp = new House<>(new Person("Bram", Gender.MALE, 23));
        House<Android> ha = new House<>(new Android());

        System.out.println(hp.toString());
        System.out.println(ha.toString());
    }
}
