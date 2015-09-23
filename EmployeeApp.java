/*
 * Employee app... question loop.
 */
package Exercise;

import java.util.Scanner;

/**
 *
 * @author Team 2
 */
public class ExerciseApp {
    
    ExerciseDAO memberList = new ExerciseDAO();
    Scanner sc = new Scanner(System.in);

    public ExerciseApp() {
        menuLoop();
    }

    private void menuLoop() {
        
        
        int id;
        String MemberName, exerciseType, Date;
        double Time;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\nExercise App");
            System.out.println("0 = Quit");
            System.out.println("1 = List All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Record");
            System.out.println("4 = Update Record");
            System.out.println("5 = Delete Record");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

            switch (choice) {
                case "1":
                    System.out.println(memberList.toString());
                    break;
                case "2":
                    id = Validator.getInt(sc, "New Member Id: ");
                    String memberNumber = Validator.getLine(sc, "What is your Member Name");
                    exerciseType = Validator.getLine(sc, "What type of exercise did you do?");
                    Date = Validator.getLine(sc, "Date");
                    Time = Validator.getDouble(sc, "Time");
                    String Comment = Validator.getLine(sc, "Comments:");
                    memberList.createRecord(new Exercise(id, memberNumber, exerciseType, Date, Time, Comment));
                    break;
                case "3":
                    id = Validator.getInt(sc, "Exercise id to retrieve: ");
                    System.out.println(memberList.retrieveRecord(id));
                    break;
                case "4":
                    id = Validator.getInt(sc, "Exercise ID to update: ");
                    String MemberNumber = Validator.getLine(sc, "Member Name: ");
                    exerciseType = Validator.getLine(sc, "Exercise Type: ");
                    Date = Validator.getLine(sc, "Today's Date: ");
                    Time = Validator.getDouble(sc, "Current Time: ");
                    String Comments = Validator.getLine(sc, "Comments: ");
                    memberList.updateRecord(new Exercise(id, MemberNumber, exerciseType, Date, Time, Comments));
                    break;
                case "5":
                    id = Validator.getInt(sc, "Exercise ID to delete: ");
                    System.out.println(memberList.retrieveRecord(id));
                    String ok = Validator.getLine(sc, "Deleter this record? (y/n) ", "^[yYnN]$");
                    if (ok.equalsIgnoreCase("Y")) {
                        memberList.deleteRecord(id);
                    }
                    break;
            }
        }
    }
}
