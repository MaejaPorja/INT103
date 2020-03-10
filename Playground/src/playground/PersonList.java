/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playground;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author User
 */
public class PersonList implements Iterable<Person>  {
    private final Person[] persons;

    public Person[] getPersons() {
        return persons;
    }
    
    
    private int modCount;
    private int cursor;
    
    public PersonList(){
        this.persons = new Person[10];
    }
    
    public void add(Person p){
        persons[cursor++] = p;
    }
    
    @Override
    public Iterator<Person> iterator() {
        return new PersonListIterator();
    }
    
    private class PersonListIterator implements Iterator<Person>{
      private int cursor;
      private final int expectedModCount = modCount; 
      @Override
      public boolean hasNext(){
          return cursor < persons.length&&persons[cursor]!=null;
      }
      @Override
      public Person next(){
          if(!hasNext()){
              throw new NoSuchElementException();
          } 
          if(expectedModCount!=modCount)
              throw new ConcurrentModificationException();
          return persons[cursor++];
      }
    }
    
    
}
