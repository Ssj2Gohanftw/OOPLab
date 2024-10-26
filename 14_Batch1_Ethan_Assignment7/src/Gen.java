import java.util.ArrayList;
public class Gen<T> {
    private T studentID;
    private ArrayList<String> student_subject;
    private ArrayList<Integer> student_marks;
    private String studentname;

    public Gen(T studentID, ArrayList<String> student_subject, ArrayList<Integer> student_marks, String studentname) {
        this.studentID = studentID;
        this.student_subject = student_subject;
        this.studentname = studentname;
        this.student_marks = student_marks;
    }
    public Gen(){};


    public <R> void getStudentID() {
        System.out.println("Student:"+studentID) ;
    }

    public void setStudentID(T studentID) {
        this.studentID = studentID;
    }

    public void getStudent_subject() {
        System.out.println("The subjects the student has:");
        for(String i:student_subject){
            System.out.println(i);
        }
    }

    public void setStudent_subject(ArrayList<String> student_subject) {
        this.student_subject = student_subject;
    }

    public void getStudent_marks() {
        System.out.println("The marks of the student:");
        for (Integer i : student_marks) {
            System.out.println(i);
        }
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public void printDetails() {
        System.out.println("Student name:" + getStudentname());
         getStudentID();
        getStudent_marks();
        getStudent_subject();
    }
    public void Average(T studentID,ArrayList<Integer> student_marks){
        int sum=0;
        for(int i:student_marks){
            sum+=i;
        }
        int numofsubsmarks=student_marks.size();
        int average=sum/numofsubsmarks;
        System.out.println("The average of the student is:"+average);
    }
}

