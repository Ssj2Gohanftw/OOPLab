// Author:Ethan D'Costa
//  Roll No:13
//  MCA
//  Start Date:24-7-24
#include <iostream>
#include <string>
using namespace std;

class Edu_Instititutes
{
public:
    string Sno;
    string InstituteName;
};

class InstitutesofNatlImportance : public Edu_Instititutes
{
public:
    string City, State, Act_name, Admin_dept;

    InstitutesofNatlImportance(string sno, string instituteName, string city, string state, string act_name, string admin_dept)
        : Edu_Instititutes{sno, instituteName}, City{city}, State{state}, Act_name{act_name}, Admin_dept{admin_dept} {}

    void printInstitutes()
    {
        cout << "Information about Institutes of National Importance:\n";
        cout << "Sno: " << Sno << "\n";
        cout << "InstituteName: " << InstituteName << "\n";
        cout << "City: " << City << "\n";
        cout << "State: " << State << "\n";
        cout << "Act Name: " << Act_name << "\n";
        cout << "Dept: " << Admin_dept << "\n";
        cout << "-------------------------------------------\n";
    }
};

class UniversitiesofIndia : public Edu_Instititutes
{
public:
    string UniName, State, Year;

    UniversitiesofIndia(string sno, string uniName, string state, string year)
        : Edu_Instititutes{sno, uniName}, State{state}, Year{year} {}

    void printInstitutes()
    {
        cout << "Information about Universities of India:\n";
        cout << "Sno: " << Sno << "\n";
        cout << "InstituteName: " << InstituteName << "\n";
        cout << "State: " << State << "\n";
        cout << "Year:" << Year << "\n";
        cout << "-------------------------------------------\n";
    }
};

int main()
{
    UniversitiesofIndia u1("1", "Aligarh Muslim University", "Uttar Pradesh", "1964");
    u1.printInstitutes();

    InstitutesofNatlImportance im1("1", "Aligarh Muslim University", "Aligarh", "Uttar Pradesh",
                                   "'Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India'",
                                   "Ministry of Education");
    im1.printInstitutes();

    return 0;
}
