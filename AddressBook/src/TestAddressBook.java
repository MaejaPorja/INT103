
import addressbook.AddressBook;
import base.Address;
import base.Company;
import base.Person;
import contact.BusinessContact;
import contact.Contact;
import contact.ContactType;
import contact.PersonContact;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class TestAddressBook {

    public PersonContact testCreatePersonContact() {
        Person ps1 = new Person("Jake", "Duley");
        LocalDate l1 = LocalDate.of(2015, 12, 31);
        Address a1 = new Address("A1", "Road1", "US", "POST1");
        //=====================================================================
        PersonContact c1 = new PersonContact(ps1, l1, a1, "email", "123456", ContactType.PERSON);
        return c1;
    }

    public BusinessContact testCreateBusinessContast() {
        Company cm2 = new Company("Dorken.com");
        Address a2 = new Address("A2", "Road2", "US", "POST2");
        //=====================================================================
        BusinessContact c2 = new BusinessContact(cm2, "HR", a2, "email", "7890", ContactType.BUSINESS);
        return c2;
    }

    public AddressBook testAddContact() {
//        Company cm2 = new Company("Dorken.com");
//        Address a2 = new Address("A2", "Road2", "US", "POST2");
//        //=====================================================================
//        Contact c2 = new BusinessContact(cm2, "HR", a2, "email", "7890", ContactType.BUSINESS);

        AddressBook ad = new AddressBook(12);
        ad.addFriend(testCreatePersonContact());
        ad.addFriend(testCreateBusinessContast());
        return ad;
    }

    public void testSortContact() {
        Contact[] ct = testAddContact().getContact();
        System.out.println("1.) Before sorting");
        System.out.println(Arrays.toString(ct));
        Arrays.sort(ct, Contact.ContactTypeComparator);
        System.out.println("2.) After sorting");
        System.out.println(Arrays.toString(ct));
        for(int l=0; l<30; l++){
            System.out.print('=');
        } System.out.println("");
    }

    public void testSearchContact() {
        AddressBook ab = testAddContact();
        
        Iterator<Contact> it = ab.iterator();
        it.next();
        System.out.println(it.next());
        //Iterator<Contact>()
        String target = "Jake";
        if(ab.searchForName(target)==0)
            System.out.printf("Found %s!%n", target);
        else
            System.out.printf("%s not found!%n", target);
        
    }

    public static void main(String[] args) {
        TestAddressBook t1 = new TestAddressBook();
//        t1.testAddContact();
        t1.testSortContact();
        //t1.testSearchContact();
    }
}
