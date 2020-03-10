/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playground;

/**
 *
 * @author User
 */
public class Person implements Comparable<Person>{
    private String name;
    private String gender;
    private int age;
    private Job job;

    public Person(String name, String gender, int age, Job job) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Job getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", gender=" + gender + ", age=" + age + ", job=" + job + '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.gender.compareTo(o.getGender());
    }
    
    
    
}
