enum State {
    UTTAR_PRADESH, MAHARASHTRA, KARNATAKA, TAMIL_NADU;
}

abstract class Edu_Institutes {
    String Sno;
    String InstituteName;


    abstract void displayInstituteDetails();
    abstract String getInstituteName();
    abstract String getSno();
    abstract String getCity();
    abstract String getState();
    void setDetails(String Sno, String InstituteName) {
        this.Sno = Sno;
        this.InstituteName = InstituteName;
    }

    void setDetails(String Sno, String InstituteName, State state) {
        this.Sno = Sno;
        this.InstituteName = InstituteName;
        System.out.println("Sno:"+Sno+"\n Institute:"+ InstituteName +"\n State: " + state);
    }
}


interface GovernmentAffiliated {
    String getGoverningBody();
}


class institutesofNatImportance extends Edu_Institutes implements GovernmentAffiliated {
    String City, State, Act_name, Admin_dept;

    public institutesofNatImportance(String Sno, String InstituteName, String City, String State, String Act_name, String Admin_dept) {
        setDetails(Sno, InstituteName);
        this.City = City;
        this.State = State;
        this.Act_name = Act_name;
        this.Admin_dept = Admin_dept;
    }


    @Override
    void
    displayInstituteDetails() {
        System.out.println("Information about the Institutions of National Importance:");
        System.out.println("S.No: " + Sno);
        System.out.println("Institute: " + InstituteName);
        System.out.println("City: " + City);
        System.out.println("State: " + State);
        System.out.println("Act Name: " + Act_name);
        System.out.println("Admin Department: " + Admin_dept);

    }

    @Override
    String getInstituteName() {
        return InstituteName;
    }

    @Override
    public String getSno() {
        return Sno;
    }

    @Override
    public String getCity() {
    return City;
    }

    @Override
    public String getState() {
        return State;
    }
    public String getActName() {
        return Act_name;
    }
    public String getAdmin_dept() {
        return Admin_dept;
    }

    @Override
    public String getGoverningBody() {
        return "Ministry of Education";
    }
}


class UniversitiesofIndia extends Edu_Institutes implements GovernmentAffiliated{

    String UniName, State, Year,City;

    public UniversitiesofIndia(String Sno, String UniName, String State,String City, String Year) {
        setDetails(Sno, UniName);
        this.UniName = UniName;
        this.City = City;
        this.State = State;
        this.Year = Year;
    }

    @Override
    void displayInstituteDetails() {
        System.out.println("Information about the Universities of India:");
        System.out.println("S.No: " + Sno);
        System.out.println("University Name: " + UniName);
        System.out.println("State: " + State);
        System.out.println("Year: " + Year);
        System.out.println("City: " + City);
        System.out.println("--------------------------------------------------------");
    }

    @Override
    String getInstituteName() {
        return UniName;
    }

    @Override
    String getSno() {
        return Sno;
    }

    @Override
    String getCity() {
        return City;
    }

    @Override
    String getState() {
        return State;
    }

    @Override
    public String getGoverningBody() {
        return "Ministry of Education";
    }
}

class IIT extends institutesofNatImportance {
    String rank;

    public IIT(String Sno, String InstituteName, String City, State State, String Act_name, String Admin_dept, String rank) {
        super(Sno, InstituteName, City, String.valueOf(State), Act_name, Admin_dept);
        this.rank = rank;
    }


    void displayInstituteDetails() {
        super.displayInstituteDetails();
        System.out.println("Rank: " + rank);
    }
}

class EduInstitutesofIndia {
    public static void main(String[] args) {
        institutesofNatImportance natInst = new institutesofNatImportance("1", "Aligarh Muslim University", "Aligarh", "Uttar Pradesh",
                "'Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India'", "Ministry of Education");
        natInst.displayInstituteDetails();
        System.out.println("Governing Body: " + natInst.getGoverningBody());


        UniversitiesofIndia uni = new UniversitiesofIndia("2", "Delhi University", "Delhi", "New Delhi","1922");
        uni.displayInstituteDetails();

        natInst.setDetails("2", "Central Leather Research Institute", State.TAMIL_NADU);

        IIT iit = new IIT("3", "IIT Bombay", "Mumbai", State.valueOf("MAHARASHTRA"),
                "'Institutes of Technology Act, 1961'", "Ministry of Education", "1");
        iit.displayInstituteDetails();
        System.out.println("---------------------");
        System.out.println("Governing Body of IIT: " + iit.getGoverningBody());

    }
}
