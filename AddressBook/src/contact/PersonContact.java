/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact;

import base.Address;
import base.Person;
import java.time.LocalDate;
import java.util.Comparator;

/**
 *
 * @author User
 */
public class PersonContact extends Contact {
    
    private Person person;
    private LocalDate dateOfBirth;
    private Comparator<PersonContact> firstname;
    private Comparator<PersonContact> lastname;

    public PersonContact(Person person, LocalDate dateOfBirth, Address address, String email, String phone, ContactType type) {
        super(address, email, phone, type);
        this.person = person;
        this.dateOfBirth = dateOfBirth;
    }

    public Person getPerson() {
        return person;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "PersonContact{" + "person=" + person + ", dateOfBirth=" + dateOfBirth + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }
    
    
    
    
}
