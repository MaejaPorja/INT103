/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playground;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class Playground {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonList p = new PersonList();
        Person P1 = new Person("Noah Swynley","Male",26,Job.ENGINEER);
        Person P2 = new Person("Zacharias Tidd","Female",19,Job.STUDENT);
        Person P3 = new Person("Edee O'Tierney","Male",20,Job.STUDENT);
        Person P4 = new Person("Alexia Lardge","Female",25,Job.PROGRAMMER);
        p.add(P1);
        p.add(P2);
        p.add(P3);
        p.add(P4);
        
        Iterator<Person> ip = p.iterator();
        while(ip.hasNext()){
         System.out.println(ip.next());
        }
        Arrays.sort(p.getPersons(),Comparator.nullsLast(Comparator.naturalOrder())/*,new NameSorter()*/);
        System.out.println("Sorted.");
        ip = p.iterator();
        while(ip.hasNext()){
         System.out.println(ip.next());
        }
    }
    
}
