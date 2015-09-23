/*
 *Logging Exercise
 */
package Exercise;

/**
 *
 * @author TEAM 2
 */
public class Exercise{
    public static void main(String[] args) {
        
    }
    //DEFINED FACTORS
    private int Id;
    private int MemberNumber;
    private String exerciseType;
    private String Date;
    private double Time;
    private String Comment;
    
        public Exercise() {
        Id = 0;
        MemberNumber = 0;
        exerciseType = "";
        Date = "";
        Time = 0;
        Comment = "";
    }

    public Exercise(int Id, int MemberNumber, String exerciseType, String Date, Double Time, String Comment) {
        this.Id = Id;
        this.MemberNumber = MemberNumber;
        this.exerciseType = exerciseType;
        this.Date = Date;
        this.Time = Time;
        this.Comment = Comment;
  //RETURNING THE FACTORS
    }

    public String getexcerciseType() {
        return exerciseType;
    }

    public void setexcerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getMemberNumber() {
        return MemberNumber;
    }

    public void setMemberNumber(int MemberNumber) {
        this.MemberNumber = MemberNumber;
    }

    public String Date() {
        return Date;
    }

    public void set(String Date) {
        this.Date = Date;
    }

    public double getTime() {
        return Time;
    }

    public void setSalary(double Time) {
        this.Time = Time;
    }
    
    public String getComment() {
        return Comment;
}
    
    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    @Override
    public String toString() {
        return "Exercise{" + "Id=" + Id + ", MemberNumber=" + MemberNumber 
                + ", exerciseType=" + exerciseType + ", Date=" + Date 
                + ", Time=" + Time + ", Comment=" + Comment +'}';
    }
}
