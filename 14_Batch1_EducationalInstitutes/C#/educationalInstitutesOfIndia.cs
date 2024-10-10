//Author:Ethan D'Costa
// Roll No:13
// MCA
// Start Date:24-7-24
using System;
namespace EducationalInstitutes
{
      class EduInstitutes
      {
            public string sno, InstituteName;
      }
      class InstitutesOfNatlImportance : EduInstitutes
      {
            public string City, State, ActName, AdminDept;
            public InstitutesOfNatlImportance(string sno, string instituteName, string city, string state, string actName, string adminDept)
            {
                  this.sno = sno;
                  this.InstituteName = instituteName;
                  this.City = city;
                  this.State = state;
                  this.ActName = actName;
                  this.AdminDept = adminDept;
            }

            public void DisplayInstitutes()
            {
                  Console.WriteLine("Information about Institutes of National Importance:");
                  Console.WriteLine($"Sno: {sno}");
                  Console.WriteLine($"InstituteName: {InstituteName}");
                  Console.WriteLine($"City: {City}");
                  Console.WriteLine($"State: {State}");
                  Console.WriteLine($"Act Name: {ActName}");
                  Console.WriteLine($"Dept: {AdminDept}");
                  Console.WriteLine("-------------------------------------------");
            }

      }
      class UniversitiesOfIndia : EduInstitutes
      {
            public string State, Year;
            public UniversitiesOfIndia(string sno, string uniName, string state, string year)
            {
                  this.sno = sno;
                  this.InstituteName = uniName;
                  this.State = state;
                  this.Year = year;
            }

            public void DisplayInstitutes()
            {
                  Console.WriteLine("Information about Universities of India:");
                  Console.WriteLine($"Sno: {sno}");
                  Console.WriteLine($"InstituteName: {InstituteName}");
                  Console.WriteLine($"State: {State}");
                  Console.WriteLine($"Year: {Year}");
                  Console.WriteLine("-------------------------------------------");
            }
      }

      class EduInstititutesofIndia
      {
            static void Main(string[] args)
            {
                  InstitutesOfNatlImportance inst1 = new InstitutesOfNatlImportance("1", "Atal Bihari Vajpayee Indian Institute of Information Technology and Management,Gwalior", "Gwalior", "Madhya Pradesh", "The Indian Institutes of Information Technology Act 2014 and their subsequent amendments", "Ministry of Education");
                  UniversitiesOfIndia u1 = new UniversitiesOfIndia("1", "Aligarh Muslim University", "Uttar Pradesh", "1964");
                  inst1.DisplayInstitutes();
                  u1.DisplayInstitutes();
            }
      }


}