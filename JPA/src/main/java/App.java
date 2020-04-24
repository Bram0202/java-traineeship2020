import dao.PersonDao;
import domain.Person;
import domain.Subject;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static util.Util.logger;

public class App {

    private final Logger log = logger(getClass());

    public static void main(String[] args) { new App().start(); }

    private void start() {
        log("Starting");
        EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
        PersonDao personDao = new PersonDao(em);

        Person insertedPerson = new Person("Bram", 32);
        personDao.insert(insertedPerson);
        int id = insertedPerson.getId();
        System.out.println(personDao.getPerson(id));

        personDao.delete(id - 1);
        personDao.update(22, 26);

        System.out.println("");
        System.out.println("Select All");
        for (Person person : personDao.selectAllPlain()) {
            System.out.println(person);
        }

        System.out.println("");
        System.out.println("Select All Named");
        for (Person person : personDao.selectAll()) {
            System.out.println(person);
        }

        System.out.println("");
        System.out.println("Select All by age");
        for (Person person : personDao.selectAll(25)) {
            System.out.println(person);
        }

        System.out.println("");
        System.out.println("Select All by name");
        for (Person person : personDao.selectAll("Dewi")) {
            System.out.println(person);
        }

        Person angela = personDao.getPerson(7);
        angela.setSubject(new Subject("Spanish"));
        personDao.update(angela);
    }

    private void log(Object o) { log.info(o + ""); }
}
