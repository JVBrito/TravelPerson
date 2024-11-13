package org.travel.person.dao;

import java.util.List;

import org.travel.person.model.Contact;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class ContactDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Contact contact) {
        em.persist(contact);
    }

    public void update(Contact contact) {
        em.merge(contact);
    }

    public void delete(Contact contact) {
        em.remove(em.contains(contact) ? contact : em.merge(contact));
    }

    public Contact findById(int id) {
        return em.find(Contact.class, id);
    }

    public List<Contact> findAll() {
        return em.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
    }
}
