package homework.h8;

import homework.h7.Gender;
import homework.h7.Person;

public class App {

    public static void main(String[] args) {
        new App();
    }

    App() {
        Person jan = new Person("Jan", 40);
        Person luuk = new Person("Luuk", 21);
        Person emma = new Person("Emma", 18);
        Person emma2 = new Person("Emma", 18);
        Person emma3 = emma;

        luuk.setGender(Gender.MALE);
        emma.setGender(Gender.FEMALE);

        System.out.println(jan.toString());
        System.out.println(emma.toString());

        System.out.println("Emma equals Jan? " + emma.equals(jan));
        System.out.println("Emma equals Emma? " + emma.equals(emma));
        System.out.println("Emma equals Emma2? " + emma.equals(emma2));
        System.out.println("Emma3 equals Emma? " + emma3.equals(emma));
        System.out.println("Emma2 equals Emma3? " + emma2.equals(emma3));
        System.out.println("Emma3 equals Emma2? " + emma3.equals(emma2));
//        try {
//            emma2.setAge(22);
//        } catch (PersonDiedException e) {
//            System.out.println(e);
//        }

        emma2.setGender(Gender.UNKNOWN);

        System.out.println(emma2.equals(emma3));
        System.out.println(emma.toString());
        System.out.println(emma2.toString());
        System.out.println(emma3.toString());
        System.out.println(emma2.equals(emma3));
        System.out.println(emma3.equals(emma2));
        emma.getClass();

        System.out.println("");
        System.out.println("De methods in Person");

    }

}
