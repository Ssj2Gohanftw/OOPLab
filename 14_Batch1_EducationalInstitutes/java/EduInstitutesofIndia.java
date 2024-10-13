//Author:Ethan D'Costa
// Roll No:13
// MCA
// Start Date:10-7-24
// Description:This program is used to implement OOP in Java.We use the educational institutes of India as an example.
// we have a parent class called Edu_Institutes which is an abstract class which is inherited by the classes institutesofNatImportance and UniversitiesofIndia.
/**
 * @author Ethan D'Costa
 * @version 1.0
 * @start 10-7-24
 * @lastModified 31-07-24
 */
import java.util.Scanner;
/**
 * Abstract class Edu_Institutes which is a parent class
 */
abstract class Edu_Institutes {
    String Sno;
    String InstituteName;
}

/**
 * Class InstitutesofNatImportance is a subclass of Edu_Institutes
 */
class InstitutesofNatImportance extends Edu_Institutes {
    String City;
    String State;
    String Act_name;
    String Admin_dept;

    /**
     * Constructor for class InstitutesofNatImportance
     * @param Sno Serial number
     * @param InstituteName Name of the Institute
     * @param City City where the Institute is located
     * @param State State where the Institute is located
     * @param Act_name Name of the Act under which the Institute was established
     * @param Admin_dept Name of the administrative department
     */
    public InstitutesofNatImportance(String Sno, String InstituteName, String City, String State, String Act_name, String Admin_dept) {
        this.Sno = Sno;
        this.InstituteName = InstituteName;
        this.City = City;
        this.State = State;
        this.Act_name = Act_name;
        this.Admin_dept = Admin_dept;
    }

    /**
     * Function to print the details about Institutes of National Importance
     */
    void printInstitutes() {
        System.out.println("Information about the Institutes of National Importance:");
        System.out.println("S.No: " + Sno);
        System.out.println("Institute: " + InstituteName);
        System.out.println("City: " + City);
        System.out.println("State: " + State);
        System.out.println("Act Name: " + Act_name);
        System.out.println("Administrative Department: " + Admin_dept);
    }
}

/**
 * Class UniversitiesofIndia is a subclass of Edu_Institutes
 */
class UniversitiesofIndia extends Edu_Institutes {
    String UniName;
    String State;
    String Year;

    /**
     * Constructor for class UniversitiesofIndia
     * @param Sno Serial number
     * @param UniName Name of the University
     * @param State State where the University is located
     * @param Year Year of Establishment
     */
    public UniversitiesofIndia(String Sno, String UniName, String State, String Year) {
        this.Sno = Sno;
        this.UniName = UniName;
        this.State = State;
        this.Year = Year;
    }

    /**
     * Function to print the details about Universities of India
     */
    void printUniversities() {
        System.out.println("Information about the Universities of India:");
        System.out.println("S.No: " + Sno);
        System.out.println("University Name: " + UniName);
        System.out.println("State: " + State);
        System.out.println("Year: " + Year);
    }
}

/**
 * Driver class
 */
public class EduInstitutesofIndia {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome User, What's your name?");
        String name = s.nextLine();
        System.out.println("Hi " + name + "!");

        while (true) {
            System.out.println("What information would you like to add?\n1. Institutes of National Importance\n2. Universities of India");
            System.out.println("Press 3 to exit the menu");
            int ch = s.nextInt();
            s.nextLine();  // Consume newline

            if (ch == 1) {
                System.out.println("Enter details for an Institute of National Importance:");
                System.out.print("Institute Name: ");
                String InstituteName = s.nextLine();
                System.out.print("City: ");
                String City = s.nextLine();
                System.out.print("State: ");
                String State = s.nextLine();
                System.out.print("Act Name: ");
                String Act_name = s.nextLine();
                System.out.print("Administrative Department: ");
                String Admin_dept = s.nextLine();

                InstitutesofNatImportance inst1 = new InstitutesofNatImportance("1", InstituteName, City, State, Act_name, Admin_dept);
                inst1.printInstitutes();

            } else if (ch == 2) {
                System.out.println("Enter details for a University of India:");
                System.out.print("University Name: ");
                String UniName = s.nextLine();
                System.out.print("State: ");
                String State = s.nextLine();
                System.out.print("Year of Establishment: ");
                String Year = s.nextLine();

                UniversitiesofIndia un1 = new UniversitiesofIndia("1", UniName, State, Year);
                un1.printUniversities();

            } else if (ch == 3) {
                System.out.println("Exiting the menu. See you again, " + name + "!");
                break;

            } else {
                System.out.println("Invalid input! Please enter a valid option number.");
            }
        }
        s.close();
    }
}