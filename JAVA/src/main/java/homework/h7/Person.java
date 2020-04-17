package homework.h7;

public class Person {
    private String name;
    private Gender gender = Gender.UNKNOWN;
    private int age;
    static final int maxAge = 130;
    static int numberOfPossibleGenders = Gender.values().length;

    public Person(String name, int age) {
        this(name, Gender.UNKNOWN, age);
    }

    public Person(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    {
    }

    public Person(String bram) {
    }

    public void haveBirthday() {
        try {
            setAge(getAge() + 1);
            System.out.println("CONGRATZ!");
        } catch (PersonDiedException e) {
            System.out.println(e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws PersonDiedException {
        if (age <= maxAge) {
            this.age = age;
        } else {
            throw new PersonDiedException(name + " has DIED!");
        }
    }

    public int getNumberOfPossibleGenders() {
        return numberOfPossibleGenders;
    }

    @Override
    public String toString() {
        return name + "(" + age + ") is " + gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        return this.name.equals(other.getName())
                && this.age == other.getAge()
                && this.gender.equals(other.getGender());
    }

    @Override
    public int hashCode() {
        return age * name.hashCode() * gender.hashCode();
    }

    public void finalize() throws Throwable {
        System.out.println("Finalizing!");
    }

}


