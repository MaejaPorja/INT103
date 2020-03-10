
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ApplicationStorage implements Storage {
    
    private Club[] clubs;
    private Student[] students;
    private int clubCounter;
    private int studentCounter;
    private static ApplicationStorage instance;
    
    private ApplicationStorage(int clubSize, int studentSize){
        this.clubs = new Club[clubSize];
        this.students = new Student[studentSize];
    }
    
    public static final ApplicationStorage getStorage(){
        return ApplicationStorage.getStorage(50, 50);
    }
    
    public static final ApplicationStorage getStorage(int clubSize, int studentSize){
        if (Objects.isNull(ApplicationStorage.instance)){
            ApplicationStorage.instance = new ApplicationStorage(clubSize, studentSize);
        }
        return ApplicationStorage.instance;
    }
    
    public Club[] getClubs(){
        return this.clubs;
    }
    public Student[] getStudents(){
        return this.students;
    }
    public int getClubCounter(){
        return this.clubCounter;
    }
    public int getStudentCounter(){
        return this.studentCounter;
    }
    public void setClubs(Club[] clubs){
        this.clubs = clubs;
    }
    public void setStudents(Student[] students){
        this.students = students;
    }
    public void setClubCounter(int clubCounter){
        this.clubCounter = clubCounter;
    }
    public void setStudentCounter(int studentCounter){
        this.studentCounter = studentCounter;
    }
    
    private boolean isClubFull(){
        return this.clubCounter >= this.clubs.length;
    }
    private boolean isStudentFull(){
        return this.studentCounter >= this.students.length;
    }
    public Club isClubExists(String clubName){
        for(int i=0; i<this.clubCounter; i++){
            if (clubName.equals(this.clubs[i].getClubName())) {
                return this.clubs[i];
            }
        } return null;
    }
    public boolean isStudentExists(long studentId){
        throw new UnsupportedOperationException();
    }
    
    public void addClub(Club club){
        if(!isClubFull()){
            this.clubs[this.clubCounter++] = club;
        }
    }
    public void addStudent(Student student){
        if(!isStudentFull()){
            this.students[this.studentCounter++] = student;
        }
    }
    
    @Override
    public void clearStorage(){
       this.clubs = new Club[this.clubs.length];
       this.students = new Student[this.clubs.length];
    }
}
