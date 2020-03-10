/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompareInterface;

import java.util.Arrays;



/**
 *
 * @author User
 */
public class Test {
    public static void main(String[] args){
        Student[] stds = new Student[3];
        stds[0] = new Student(5, "jame", 18);
        stds[1] = new Student(2, "Annie", 20);
        stds[2] = new Student(4, "fai", 17);
        
        for(Student std : stds){
            System.out.println(std);
        }
        
        System.out.println("1-----");
        Arrays.sort(stds);
        for(Student std: stds){
            System.out.println(std);
        }
        
        System.out.println("2-----");
        ageComparater ageComp = new ageComparater();
        Arrays.sort(stds,ageComp);
        for(Student std: stds){
            System.out.println(std);
        }
        
        System.out.println("3-----");
        Arrays.sort(stds,Student.ageComparater());
        for(Student std: stds){
            System.out.println(std);
        }
        
    }
}
