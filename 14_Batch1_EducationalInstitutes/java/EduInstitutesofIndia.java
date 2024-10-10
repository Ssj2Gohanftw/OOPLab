//Author:Ethan D'Costa
// Roll No:13
// MCA
// Start Date:10-7-24
// Description:This program is used to implement OOP in Java.We use the educational institutes of India as an example.
// we have a parent class called Edu_Institutes which is an abstract class which is inherited by the classes instituteNatImportance and UniversitiesofIndia.
abstract class Edu_Institutes {
    String Sno;
    String InstituteName;
}

class institutesofNatImportance extends Edu_Institutes {
    String City, State, Act_name, Admin_dept;

    public institutesofNatImportance(String Sno, String InstituteName,String City, String State, String Act_name, String Admin_dept) {
        this.Sno=Sno;
        this.InstituteName=InstituteName;
        this.City = City;
        this.State = State;
        this.Act_name = Act_name;
        this.Admin_dept = Admin_dept;
    }

    void printInstitutes() {
        System.out.println("Information about the Institutions of National Importance:");
        System.out.println("S.No:" + Sno);
        System.out.println("Institute:" + InstituteName);
        System.out.println("City:" + City);
        System.out.println("State:" + State);
        System.out.println("Act Name:" + Act_name);
        System.out.println("Admin Department:" + Admin_dept);
    }
}
class UniversitiesofIndia extends Edu_Institutes {
    String UniName,State,Year;

    public UniversitiesofIndia(String Sno, String UniName,String State,String Year) {
        this.Sno=Sno;
        this.UniName=UniName;
        this.State = State;
        this.Year= Year;
    }

    void printInstitutes() {
        System.out.println("Information about the Universities of India:");
        System.out.println("S.No:" + Sno);
        System.out.println("University Name:" + UniName);
        System.out.println("State:" + Sno);
        System.out.println("Year:" + Year);
        
    }
}
class EduInstitutesofIndia{
    public static void main(String[] args) {
        institutesofNatImportance e=new institutesofNatImportance("1","Aligarh Muslim University","Aligarh","Uttar Pradesh","'Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India'","Ministry of Education");
        e.printInstitutes();
    }  
 }
