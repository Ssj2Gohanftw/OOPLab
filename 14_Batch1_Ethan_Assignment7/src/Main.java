import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static <T> void main(String[] args) {
        Gen<Integer> intobj= new Gen<Integer>();
        try {

            Scanner s = new Scanner(System.in);
            while (true)
                 {
                    System.out.println("Hi,what is your name?");
                    String name = s.next();
                    System.out.println("Hi," + name + "! How many subjects do you have?");
                    int subnum = s.nextInt();
                    System.out.println("What are the subjects that you have?");
                    ArrayList<String> subjects = new ArrayList<String>();
                    for (int i = 0; i < subnum; i++) {
                        String subnames = s.next();
                        subjects.add(subnames);
                    }
                    System.out.println("What marks have you scored in each subject?");
                    ArrayList<Integer> student_marks = new ArrayList<>();
                    for (int i = 0; i < subnum; i++) {
                        Integer submarks = s.nextInt();
                        student_marks.add(submarks);
                    }
                   intobj = new Gen<Integer>(101, subjects, student_marks, name);
                    intobj.printDetails();
                    System.out.println("Press 0 to exit or press any other number to continue");
                    int continue_menu = s.nextInt();
                    if (continue_menu == 0) {
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("The user details have been saved successfully!");
        }
    }
    }
