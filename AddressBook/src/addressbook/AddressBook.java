/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import contact.BusinessContact;
import contact.Contact;
import contact.PersonContact;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class AddressBook {

    private Contact[] friends;
    private int count;

    public AddressBook(int size) {
        if (size <= 0) {
            this.friends = new Contact[10];
        } else {
            this.friends = new Contact[size];
        }
    }

    public int getCount() {
        return count;
    }
    
    public Contact[] getContact(){
        return friends;
    }
    
    public boolean isFull() {
        return friends.length == count;
    }

    public Iterator<Contact> iterator() {
        return new Iterator<Contact>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            public Contact next() {
                if (index == count) {
                    System.out.println("No More Contact.");
                }
                return friends[index++];
            }
        };
    }

    public boolean addFriend(Contact contact) {
        if (isFull()) {
            return false;
        } else {
            friends[count++] = contact;
            return true;
        }
    }

    public int searchForName(String name) {
        for (int i = 0; i < friends.length; i++) {
            if (friends[i] instanceof BusinessContact) {
                BusinessContact bc = (BusinessContact)friends[i];
                if(name.compareTo(bc.getCompany().getName())==0)
                    return 0;
            }
            else if(friends[i] instanceof PersonContact){
                PersonContact pc = (PersonContact) friends[i];
                if(name.compareTo(pc.getPerson().getFirstname())==0)
                    return 0;
            }          
        }
        return -1;
    }

}
