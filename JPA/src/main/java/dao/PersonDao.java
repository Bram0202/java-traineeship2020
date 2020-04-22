package dao;

import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonDao {

    private final EntityManager em;

    public PersonDao(EntityManager em) { this.em = em; }

    public Person getPerson(int id) { return em.find(Person.class, id); }

    // CREATE (INSERT)
    public void insert(Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    // READ (SELECT)
    public Person select(int id) {
        return em.find(Person.class, id);
    }

    public List<Person> selectAllPlain() {
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        return query.getResultList();
    }

    public List<Person> selectAll() {
        TypedQuery<Person> query = em.createNamedQuery("selectAll", Person.class);
        return query.getResultList();
    }

    public List<Person> selectAll(String name) {
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.name = :name", Person.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Person> selectAll(int age) {
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.age = :age", Person.class);
        query.setParameter("age", age);
        return query.getResultList();
    }

    // UPDATE
    public Person update(int id, String name) {
        Person p = select(id);
        if (p != null) {
            em.getTransaction().begin();
            p.setName(name);
            em.getTransaction().commit();
        }
        return p;
    }

    public Person update(int id, int age) {
        Person p = select(id);
        if (p != null) {
            em.getTransaction().begin();
            p.setAge(age);
            em.getTransaction().commit();
        }
        return p;
    }

    public Person update(Person p) {
        em.getTransaction().begin();
        Person merged = em.merge(p);
        em.getTransaction().commit();
        return merged;
    }

    // DELETE
    public void delete(int id) {
        Person select = select(id);
        if (select != null) {
            em.getTransaction().begin();
            em.remove(select);
            em.getTransaction().commit();
        }
    }


}