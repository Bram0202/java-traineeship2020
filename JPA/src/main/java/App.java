import dao.PersonDao;
import domain.Person;
import domain.Subject;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) { new App().start(); }

    private void start() {
        EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
        PersonDao personDao = new PersonDao(em);

        Person insertedPerson = new Person("Marjolein", 32);
        personDao.insert(insertedPerson);
        int id = insertedPerson.getId();
        System.out.println(personDao.getPerson(id).toString());

        personDao.delete(id - 1);
        personDao.update(22, 26);

        System.out.println("");
        System.out.println("Select All");
        for (Person person : personDao.selectAllPlain()) {
            System.out.println(person.toString());
        }

        System.out.println("");
        System.out.println("Select All Named");
        for (Person person : personDao.selectAll()) {
            System.out.println(person.toString());
        }

        System.out.println("");
        System.out.println("Select All by age");
        for (Person person : personDao.selectAll(25)) {
            System.out.println(person.toString());
        }

        System.out.println("");
        System.out.println("Select All by name");
        for (Person person : personDao.selectAll("Dewi")) {
            System.out.println(person.toString());
        }

        Person angela = personDao.getPerson(7);
        angela.setSubject(new Subject("Spanish"));
        personDao.update(angela);
    }
}
