package first.services;

import first.domain.Student;
import first.domain.Students;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static first.domain.Values.STUDENTS;
import static java.util.stream.Collectors.toList;

@Stateful
public class StudentService implements Serializable {

    List<Student> students = new ArrayList<>(STUDENTS);

    public Student get(int id) {
        return students.get(id);
    }

    public Students getAll() {
        return Students.of(students);
    }

    public Student remove(int id) {
        return students.remove(id);
    }

    private List<Student> filterStudentsBy(String lastname) {
        return students.stream()
                .filter(s -> lastname.toUpperCase().contains(s.getLastname().toUpperCase()))
                .collect(toList());
    }

    public Students find(String lastname) {
        return Students.of(filterStudentsBy(lastname));
    }

    public boolean add(Student student) {
        return students.add(student);
    }
}
