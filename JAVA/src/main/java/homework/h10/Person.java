package homework.h10;

import homework.h12.MyAnnotation;
import homework.h12.MyAnnotation2;

import java.util.ArrayList;

@MyAnnotation
public class Person extends Human {

    private String name;
    private Gender gender;
    private int age;
    static final int MAX_AGE = 130;
    private ArrayList<HistoryRecord> historyRecords = new ArrayList<>();
    private int historyRecordsCounter = 0;

    public Person(String name) {
        this(name, Gender.UNKNOWN, 0);
    }

    public Person(String name, int age) {
        this(name, Gender.UNKNOWN, age);
    }

    public Person(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    @MyAnnotation
    public String greet() {
        return "Hello, my name is " + name + ". Nice to meet you!";
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

    @MyAnnotation2
    public void setAge(int age) throws PersonDiedException, PersonsAgeBelowZeroException {
        if (age <= MAX_AGE && age >= 0) {
            this.age = age;
        } else if (age < 0) {
            throw new PersonsAgeBelowZeroException("A person can't be below the age of 0!");
        } else {
            throw new PersonDiedException(name + " has DIED!");
        }
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

    public void haveBirthday() throws PersonDiedException, PersonsAgeBelowZeroException {
        if (age < MAX_AGE) {
            setAge(getAge() + 1);
            System.out.println("CONGRATZ!");
        } else {
            throw new PersonDiedException(name + " died!");
        }
    }

    public void finalize() {
        System.out.println("Finalizing!");
    }

    // Homework 11.1
    @MyAnnotation
    private static class HistoryRecord {
        private String description;

        HistoryRecord(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    // Homework 11.2
    public void addHistory(String descr) throws IndexOutOfBoundsException {
        historyRecords.add(historyRecordsCounter, new HistoryRecord(descr));
        historyRecordsCounter++;
    }

    // Homework 11.3
    public void printHistory() {
        for (HistoryRecord records : historyRecords) {
            if (records == null) {
                break;
            }
            System.out.println(records.toString());
        }
    }

    // Homework 11.4
    @MyAnnotation
    @MyAnnotation2
    public Human createSubHuman() {
        return new Human() {
            @Override
            public String greet() {
                return "Sub is the best.";
            }
        };
    }

}


