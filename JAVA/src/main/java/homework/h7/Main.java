package homework.h7;

public class Main
{
    public static void main(String[] args) {
        Person p = new Person("Bram", 130);

        System.out.println(p.getGender());
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        System.out.println(p.getAge());
        p.haveBirthday();
        System.out.println(p.getAge());
        p.haveBirthday();
        System.out.println(p.getAge());
        System.out.println(Person.numberOfPossibleGenders);
    }
}
