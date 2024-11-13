package org.travel.person.bean;

import java.io.Serializable;
import java.util.List;

import org.travel.person.dao.PersonDAO;
import org.travel.person.model.Person;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("personBean")
@SessionScoped
public class PersonBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private Person person = new Person();

    private PersonDAO personDAO;
    
    @Inject
    public PersonBean(PersonDAO personDAO) {
		super();
		this.personDAO = personDAO;
	}

	public void save() {
        personDAO.save(person);
        person = new Person();
    }

    public void delete(Person person) {
        personDAO.delete(person);
    }

    public List<Person> getPeople() {
        return personDAO.findAll();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
