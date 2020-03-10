/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.Objects;

/**
 *
 * @author User
 */
public class Person {
    private String firstname;
    private String lastname;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean equals(Object obj) {
       Person other = (Person) obj;
       return firstname.equals(other.getFirstname()) 
           && lastname.equals(other.getLastname());
    }

    @Override
    public String toString() {
        return "Person{" + "firstname=" + firstname + ", lastname=" + lastname + '}';
    }

 
    
    
}
