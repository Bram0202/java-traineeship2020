package homework.h10;

import java.util.HashSet;

public class App {

    public static void main(String[] args) {
        Person person = new Person("Bram");
        System.out.println("Person: " + person.greet());

        Android android = new Android();
        System.out.println("Android: " + android.greet());

        Human employee = new Employee(("John"));
        System.out.println("Employee: " + employee.greet());

        Human teacher = new Teacher("Ellis");
        System.out.println("Teacher: " + teacher.greet());
        System.out.println("");

        person.addHistory("Born");
        person.addHistory("First Birthday");
        person.addHistory("First School day.");
        person.addHistory("Started Java Traineeship!");

        person.printHistory();
        System.out.println("");

        System.out.println(person.createSubHuman().greet());
        System.out.println(person.greet());

        // HW14.
        HashSet<Person> hm = new HashSet<>();
        hm.add(person);
        hm.add(new Person("John"));
        hm.add(new Person("John"));
        hm.add(new Person("Boris"));

        for (Person p : hm) {
            System.out.println(p.toString());
        }
    }

}
