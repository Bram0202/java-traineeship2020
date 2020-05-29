package first.services;

import first.dao.StudentDao;
import first.domain.Student;
import first.domain.Students;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static first.domain.Values.STUDENTS;
import static java.util.stream.Collectors.toList;

@Stateful
public class StudentService implements Serializable {

    @Inject
    private StudentDao studentDao;

    List<Student> students = new ArrayList<>(STUDENTS);

    // CREATE
    public Student add(Student student) {
        return studentDao.insert(student);
    }

    // READ
    public Student get(int id) {
        return students.get(id);
    }

    public Students getAll() {
        return Students.of(students);
    }

    private List<Student> filterStudentsBy(String lastname) {
        return students.stream()
                .filter(s -> lastname.toUpperCase().contains(s.getLastname().toUpperCase()))
                .collect(toList());
    }

    public Students find(String lastname) {
        return Students.of(filterStudentsBy(lastname));
    }

    // DELETE
    public Student remove(int id) {
        return students.remove(id);
    }
}
