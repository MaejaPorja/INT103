/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact;

import base.Address;
import java.util.Comparator;

/**
 *
 * @author User
 */
public abstract class Contact {
    private  Address address;
    private String email;
    private  String phone;
    private  ContactType type;
    
    public static Comparator<Contact> ContactTypeComparator = new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                if(c1==null&&c2==null)
                    return 0;
                else if(c1==null)
                    return 1;
                else if (c2==null)
                    return -1;
                return c1.getType().toString().compareTo(c2.getType().toString());
            }
        };;

    public Contact(Address address, String email, String phone, ContactType type) {
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public ContactType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Contact{" + "address=" + address + ", email=" + email + ", phone=" + phone + ", type=" + type + '}';
    }
    
}
