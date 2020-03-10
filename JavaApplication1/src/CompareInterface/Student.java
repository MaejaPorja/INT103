/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompareInterface;

import java.util.Comparator;
import java.util.Objects;


/**
 *
 * @author User
 */
public class Student implements Comparable<Student> {
    private long id;
    private String name;
    private int age;

    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public int compareTo(Student t){
        Objects.requireNonNull(t);
        return Long.compare(this.id, t.id);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
    
    public static Comparator ageComparater(){
        return new ageComparater();
    }
    public static Comparator nameComparater(){
        return new NameComparater();
    }
    
//    public static Comparator nameComparater(){
//        return new Comparator<Student>(){};
//    }
    
    public static Comparator nameComparaterV2(){
        return new Comparator<Student>(){
        @Override
        public int compare(Student t1,Student t2){
        return t1.getName().compareTo(t2.getName());
        }
    };
    }
}
class NameComparater implements Comparator<Student>{
    @Override
    public int compare(Student t1,Student t2){
        return t1.getName().compareTo(t2.getName());
    }
}
