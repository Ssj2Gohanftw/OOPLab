# Author:Ethan D'Costa
#  Roll No:13
#  MCA
# Start Date:17-7-24
class Edu_Institutes:
    def __init__(self, sno, InstituteName):
        self.sno = sno
        self.InstituteName = InstituteName


class InstitutesofNatImp(Edu_Institutes):
    def __init__(self, sno, InstituteName, City, State, Act_name, Dept):
        super().__init__(sno, InstituteName)
        self.City = City
        self.State = State
        self.Act_name = Act_name
        self.Dept = Dept

    def InstituteInfo(self):
        print("Sno:", self.sno)
        print("Name of the Institute:", self.InstituteName)
        print("City:", self.City)
        print("State:", self.State)
        print("Name of Act:", self.Act_name)
        print("Department:", self.Dept)


class UniversitiesofIndia(InstitutesofNatImp):
    def __init__(self, sno, InstituteName, City, Act_name, Dept, UniName, State, Year):
        super().__init__(sno, InstituteName, City, Act_name, Dept)
        self.UniName = UniName
        self.State = State
        self.Year = Year

    def InstituteInfo(self):
        print("Sno:", self.sno)
        print("Name of the University:", self.UniName)
        print("State:", self.State)
        print("Year:", self.Year)


def main():

    nat1 = InstitutesofNatImp("1", "Aligarh Muslim University", "Aligarh", "Uttar Pradesh",
                              "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India",
                              "Ministry of Education")
    nat1.InstituteInfo()
    nat2 = InstitutesofNatImp("2", "Banaras Hindu University", "Varanasi", "Uttar Pradesh",
                              "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India", "Ministry of Education")
    nat2.InstituteInfo()


if __name__ == "__main__":
    main()
