package team.alex.Grupp1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

    /* Entity Attributes */
    @Id
    @Column(name="SSN")       long ssN;
    @Column(name="firstname") String firstName;
    @Column(name="lastname")  String lastName;
    @Column(name="age")       int age;
    @Column(name="gender")    char gender;
    @Column(name="city")      String cityOfResidence;
    @Column(name="country")   String countryOfResidence;

    /* Default constructor */
    public Person() {}
    
    /**
        Person constructor
        @param fname    Firstname
        @param lname    Lastname
        @param age      Person age
        @param gender   Person gender
        @param ssn      Social security number
        @param city     city
        @param country  Country
    */
    public Person(String fname, String lname, int age, char gender, long ssn, String city, String country) {
        setFirstName(fname);
        setLastName(lname);
        setAge(age);
        setGender(gender);
        setSsN(ssn);
        setCity(city);
        setCountry(country);
    }

    /* Getters */
    public String getFirstName() { return firstName;          }
    public String getLastName()  { return lastName;           }
    public int    getAge()       { return age;                }
    public char   getGender()    { return gender;             }
    public long   getSsN()       { return ssN;                }
    public String getCity()      { return cityOfResidence;    }
    public String getCountry()   { return countryOfResidence; }

    /* Setters */
    public void setAge(int age)                { this.age = age; }
    public void setGender(char gender)         { this.gender = gender; }
    public void setLastName(String lastName)   { this.lastName = lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setSsN(long ssN)               { this.ssN = ssN; }
    public void setCity(String city)           { this.cityOfResidence = city; }
    public void setCountry(String country)     { this.countryOfResidence = country; }
    
    @Override
    public String toString() {
    	return String.format("%d | %s | %s | %d | %s | %s | %s", getSsN(), getLastName(), getFirstName(), getAge(), getGender(), getCity(), getCountry());
    }

}
