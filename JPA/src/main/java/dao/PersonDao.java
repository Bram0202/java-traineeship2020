package dao;

import domain.Person;

import javax.persistence.EntityManager;

public class PersonDao {

    private final EntityManager em;

    public PersonDao(EntityManager em) { this.em = em; }

    public Person getPerson(int id) { return em.find(Person.class, id); }

    public void insert(Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
}