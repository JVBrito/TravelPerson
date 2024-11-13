package org.travel.person.dao;

import java.util.List;

import org.travel.person.model.Document;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class DocumentDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Document document) {
        em.persist(document);
    }

    public void update(Document document) {
        em.merge(document);
    }

    public void delete(Document document) {
        em.remove(em.contains(document) ? document : em.merge(document));
    }

    public Document findById(int id) {
        return em.find(Document.class, id);
    }

    public List<Document> findAll() {
        return em.createQuery("SELECT d FROM Document d", Document.class).getResultList();
    }
}
