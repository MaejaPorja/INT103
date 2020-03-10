/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Club {

    private String clubName;
    private String clubInitialName;
    private Student[] memberList;
    private int numberOfMembers;
    private String status;

    public Club(String clubName) {
        this(clubName, "Default Name");
    }

    public Club(String clubName, String clubInitialName) {
        this(clubName, clubInitialName, 10);
    }

    public Club(String clubName, String clubInitialName, int clubSize) {
        this.clubName = clubName;
        this.clubInitialName = clubInitialName;
        if (clubSize < 0) {
            clubSize = 5;
        }
        this.memberList = new Student[clubSize];
        this.status = "OPEN";

    }

    public String getClubName() {
        return clubName;
    }

    public String getClubInitialName() {
        return clubInitialName;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public String getStatus() {
        return status;
    }

    public Student[] getMembersList() {
        return memberList;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubInitialName(String clubInitialName) {
        this.clubInitialName = clubInitialName;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean memberRequestToEditMember(Student requestFrom, long studentId) {
        if (isSubscribed(requestFrom)) {
            Student student = getMember(studentId);
            if (student != null) {
                editMember(student);
                return true;
            } else{
                System.out.printf("Member %s doesn't exists!\n", studentId);
                return false;
            }
        }
        System.out.printf("%s is not allowed to edit %s\n", 
                requestFrom.getStudentId(), studentId);
        return false;
    }

    private Student editMember(Student member) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("You're editing %d\n", member.getStudentId());
        System.out.print("New member name: ");
        String newMemberName = sc.nextLine();
        System.out.print("New member faculty: ");
        String newMemberFaculty = sc.nextLine();
        member.setStudentName(newMemberName);
        member.setFacultyName(newMemberFaculty);
        return member;
    }

    private boolean isOpen() {
        return this.status.equals("OPEN");
    }

    private boolean isSubscribed(Student student) {
        for (int i = 0; i < this.numberOfMembers; i++) {
            if (memberList[i].getStudentId() == student.getStudentId()) {
                return true;
            }
        };
        return false;
    }

    private Student getMember(long studentId) {
        for (int i = 0; i < this.numberOfMembers; i++) {
            if (memberList[i].getStudentId() == studentId) {
                return memberList[i];
            }
        };
        return null;
    }

    public boolean memberRequestMemberList(Student requestFrom) {
        return isSubscribed(requestFrom);
    }

    public boolean subscribe(Student student) {
        if (isOpen() && !isSubscribed(student)) {
            this.memberList[this.numberOfMembers++] = student;
            if(this.numberOfMembers >= this.memberList.length){
                this.status = "CLOSE";
            }
            return true;
        } System.out.printf("Sorry, club %s is CLOSE.", this.clubName);
        return false;
    }

    public boolean unsubscribe(Student student) {
        for (int i = 0; i < this.numberOfMembers; i++) {
            if (memberList[i].getStudentId() == student.getStudentId()) {
                memberList[i] = null;
                int delta = memberList.length - 1 - i;
                for (int x = i; x < delta; x++) {
                    Student tempMember = memberList[x];
                    memberList[x] = memberList[x + 1];
                    memberList[x + 1] = tempMember;
                }
                this.numberOfMembers--;
                if(this.numberOfMembers < this.memberList.length){
                    this.status = "OPEN";
                }
                return true;
            }
        };
        return false;
    }

    @Override
    public String toString() {
        return "Club{" + "clubName=" + clubName + ", clubInitialName=" + clubInitialName + ", memberList=" + memberList + ", numberOfMembers=" + numberOfMembers + ", status=" + status + '}';
    }

}
