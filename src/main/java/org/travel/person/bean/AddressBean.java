package org.travel.person.bean;


import java.io.Serializable;
import java.util.List;

import org.travel.person.dao.AddressDAO;
import org.travel.person.model.Address;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AddressBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Address address = new Address();
    private List<Address> addresses;


    private AddressDAO addressDAO;

    @Inject
    public AddressBean(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    public void save() {
        if (address.getId() == 0) {
            addressDAO.save(address);
        } else {
            addressDAO.update(address);
        }
        address = new Address();
        addresses = null;
    }

    public void delete(Address address) {
        addressDAO.delete(address);
        addresses = null;
    }

    public List<Address> getAddresses() {
        if (addresses == null) {
            addresses = addressDAO.findAll();
        }
        return addresses;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
