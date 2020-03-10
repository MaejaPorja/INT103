/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu {

    private int selectedChoice;
    private final ApplicationStorage storage;

    public MainMenu() {
        this.storage = ApplicationStorage.getStorage();
    }

    public void display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("<<Main Menu>>");
        System.out.println("1. New club");
        System.out.println("2. Membership Subscribe");
        System.out.println("3. Edit Membership Information ");
        System.out.println("4. Membership Unsubscribe ");
        System.out.println("5. List Members ");
        System.out.println("6. List Clubs ");
        System.out.println("7. Exit ");
        System.out.print("Enter Your Menu [1‐7]: ");
        selectedChoice = sc.nextInt();
    }

    public void go() {
        switch (selectedChoice) {
            case 1:
                newClub();
                break;
            case 2:
                memberSub();
                break;
            case 3:
                editInformation();
                break;
            case 4:
                memberUnsub();
                break;
            case 5:
                listMembers();
                break;
            case 6:
                listClubs();
                break;
            case 7:
                exit(0);
                break;
            default:
                System.out.println("QwQ");
        }
    }

    public int getSelectedChoice() {
        return selectedChoice;
    }

    public void newClub() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter club name: ");
        String clubName = sc.nextLine();
        System.out.print("Enter club initials name: ");
        String clubInitalsName = sc.nextLine();
        System.out.print("Number of members in club: ");
        int clubSize = sc.nextInt();
        storage.addClub(new Club(clubName, clubInitalsName, clubSize));
    }

    public void memberSub() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Subscribe to club: ");
        String subscribeToClub = sc.nextLine();
        System.out.print("Enter student id: ");
        long studentId = Long.parseLong(sc.nextLine());
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();
        System.out.print("Enter student faculty: ");
        String studentFaculty = sc.nextLine();
        
        int clubCounter = storage.getClubCounter();
        Club[] clubs = storage.getClubs();
        for(int i=0; i<clubCounter; i++){
            if (subscribeToClub.equals(clubs[i].getClubName())) {
                if (clubs[i].subscribe(new Student(studentId, studentName, studentFaculty))){
                    storage.setClubs(clubs);
                    System.out.printf("Subscribed %d to %s\n",studentId,subscribeToClub);
                    return;
                }
                System.out.printf("Failed to subscribe %d to %s\n",studentId,subscribeToClub);
                return;
            }
        }
        System.out.printf("Club %s not exists!\n", subscribeToClub);
    }

    public void memberUnsub() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Unsubscribe from club: ");
        String unsubscribeFromClub = sc.nextLine();
        System.out.print("Enter student id: ");
        long studentId = sc.nextLong();
        
        int clubCounter = storage.getClubCounter();
        Club[] clubs = storage.getClubs();
        for(int i=0; i<clubCounter; i++){
            if (unsubscribeFromClub.equals(clubs[i].getClubName())) {
                if(clubs[i].unsubscribe(new Student(studentId))){
                    storage.setClubs(clubs);
                    System.out.printf("Unsubscribed %d from %s\n",studentId,unsubscribeFromClub);
                    return;
                } 
                System.out.printf("Failed to unsubscribed %d from %s\n",studentId,unsubscribeFromClub);
                return;
            }
        }
        System.out.printf("Club %s not exists!", unsubscribeFromClub);
    }

    public void editInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter club name: ");
        String clubName = sc.nextLine();
        Club club = storage.isClubExists(clubName);
        if(!Objects.isNull(club)){
            System.out.print("Who are you(id): ");
            long clientId = Long.parseLong(sc.nextLine());
            Student client = new Student(clientId);
            System.out.print("Edit(id): ");
            long studentId = Long.parseLong(sc.nextLine());
            boolean editCompleted = 
                    club.memberRequestToEditMember(client, studentId);
            if(editCompleted){
                System.out.printf("Successfully edit %s by %s\n", studentId, clientId);
            } else{
                System.out.printf("Failed to edit %s by %s\n", studentId, clientId);
            }
            
        } else {
            System.out.printf("Club %s not exists!\n", clubName);
        }
    }

    public void listMembers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter club name: ");
        String clubName = sc.nextLine();
        
        Club club = storage.isClubExists(clubName);
        if (!Objects.isNull(club)){
            System.out.println("-------------------------------------------------------------");
            int memberCounter = club.getNumberOfMembers();
            Student[] members = club.getMembersList();
            for (int j=0; j<memberCounter; j++){
                System.out.println(members[j].getStudentId() + " "
                        +members[j].getStudentName() + " "
                        +members[j].getFacultyName()
                );
            }
            System.out.println("-------------------------------------------------------------");
            return;
        }
        System.out.printf("Club %s not exists!\n", clubName);
    }
    
    public void listClubs(){
        System.out.println("-------------------------------------------------------------");
        int clubCounter = storage.getClubCounter();
        Club[] clubs = storage.getClubs();
        for (int i=0; i<clubCounter; i++){
            System.out.println(clubs[i].getClubName());
        }
        System.out.println("-------------------------------------------------------------");
    }
    
    public void exit(int exitedCode) {
        System.out.println("Bye!");
        System.exit(exitedCode);
    }
}
