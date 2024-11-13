package org.travel.person.dao;

import java.util.List;

import org.travel.person.model.Address;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@ApplicationScoped
public class AddressDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Address address) {
        em.persist(address);
    }

    public void update(Address address) {
        em.merge(address);
    }

    public void delete(Address address) {
        em.remove(em.contains(address) ? address : em.merge(address));
    }

    public Address findById(int id) {
        return em.find(Address.class, id);
    }

    public List<Address> findAll() {
        return em.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }
}
