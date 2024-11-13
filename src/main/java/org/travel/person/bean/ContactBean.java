package org.travel.person.bean;


import java.io.Serializable;
import java.util.List;

import org.travel.person.dao.ContactDAO;
import org.travel.person.model.Contact;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ContactBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Contact contact = new Contact();
    private List<Contact> contacts;

    private ContactDAO contactDAO;
    
    @Inject
    public ContactBean(ContactDAO contactDAO) {
		super();
		this.contactDAO = contactDAO;
	}

	public void save() {
        if (contact.getId() == 0) {
            contactDAO.save(contact);
        } else {
            contactDAO.update(contact);
        }
        contact = new Contact();
        contacts = null;
    }

    public void delete(Contact contact) {
        contactDAO.delete(contact);
        contacts = null;
    }

    public List<Contact> getContacts() {
        if (contacts == null) {
            contacts = contactDAO.findAll();
        }
        return contacts;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
