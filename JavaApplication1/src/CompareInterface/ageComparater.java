/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompareInterface;
import java.util.Comparator;
/**
 *
 * @author User
 */
public class ageComparater implements Comparator<Student>{
    @Override
    public int compare(Student t1,Student t2){
        return t1.getAge()-t2.getAge();
    }
}
