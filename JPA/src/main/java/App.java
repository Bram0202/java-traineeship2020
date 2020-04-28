import dao.PersonDao;
import dao.SubjectDao;
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
        log("Starting...");
        EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
        PersonDao personDao = new PersonDao(em);
        SubjectDao subjectDao = new SubjectDao(em);

        Person insertedPerson = new Person("Bram", 32);
        personDao.insert(insertedPerson);
        int id = insertedPerson.getId();
        log(personDao.getPerson(id));

        // TODO: Remove before production!
        personDao.delete(id - 1); // NOT PROUCTION SAVE! Just to keep the DB small during testing :)
        personDao.update(22, 26);

        log("Select All");
        personDao.selectAllPlain().forEach(this::log);

        log("Select All Named");
        personDao.selectAll().forEach(this::log);

        log("Select All by age");
        personDao.selectAll(25).forEach(this::log);

        log("Select All by name");
        personDao.selectAll("Bram").forEach(this::log);

        // WARNING: Breekt waarschijnlijk de app wanneer er geen exacte kopie van de DB aanwezig is.
        Person angela = personDao.getPerson(7);
        Subject biology = subjectDao.getSubject(40);
        angela.setSubjects(biology);
        personDao.update(angela);

        log("Select All with subject (Join)");
        personDao.selectAllPlain().forEach(this::log);

        personDao.selectAllWithSubject().forEach(this::log);
        personDao.selectAllWithSubjectJF().forEach(this::log);
    }

    private void log(Object o) { log.info(o + ""); }
}
