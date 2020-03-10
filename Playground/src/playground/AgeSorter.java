/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playground;

import java.util.Comparator;

/**
 *
 * @author User
 */
public class AgeSorter implements Comparator<Person> {
    
    @Override
    public int compare(Person o1, Person o2) {
        if(o1==null)
            return 1;
        else if(o2==null)
            return -1;
        else return o1.getAge() - o2.getAge();
    }

}
