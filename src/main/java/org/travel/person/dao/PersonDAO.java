package org.travel.person.dao;

import java.util.List;

import org.travel.person.model.Person;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class PersonDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    public void update(Person person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public void delete(Person person) {
        em.getTransaction().begin();
        em.remove(em.contains(person) ? person : em.merge(person));
        em.getTransaction().commit();
    }

    public Person findById(int id) {
        return em.find(Person.class, id);
    }

    public List<Person> findAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
}
