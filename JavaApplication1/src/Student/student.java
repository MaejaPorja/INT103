/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

/**
 *
 * @author User
 */
public class student {
    private long studentId;
    
     public student() {    
         //student constructor
         this(0);
     }

    public student(long studentId) {
        this.studentId = studentId;
    }
    
    @Override
    public String toString(){
        return "student{"+ studentId+ "}";
    }
}
