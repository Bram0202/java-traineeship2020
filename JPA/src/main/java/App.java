import dao.PersonDao;
import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) { new App().start(); }

    private void start() {
        EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
        PersonDao personDao = new PersonDao(em);

        Person p = new Person("Marieke", 25);
        personDao.insert(p);
        int id = p.getId();
        System.out.println(personDao.getPerson(id).toString());
    }
}
