/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Student {
    private long studentId;
    private String studentName;
    private String facultyName;

    public Student(long studentId) {
		this(studentId, "Default Name");
    }

    public Student(long studentId, String studentName) {
        this(studentId, studentName, "Information Technology");
    }

    public Student(long studentId, String studentName, String facultyName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.facultyName = facultyName;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "StudentId : " + studentId + "Name :" + studentName + "Faculty : " + facultyName;
    }

}
