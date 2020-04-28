package dao;

import domain.Subject;

import javax.persistence.EntityManager;

public class SubjectDao {

    private final EntityManager em;

    public SubjectDao(EntityManager em) { this.em = em; }

    public Subject getSubject(int id) { return em.find(Subject.class, id); }
}
