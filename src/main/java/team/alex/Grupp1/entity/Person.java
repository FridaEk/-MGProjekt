package team.alex.Grupp1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	
	String firstName;
	String lastName;
	int age;
	char gender;
	@Id
	long ssN;
	String cityOfResidence;
	String countryOfResidence;
	
	Person() { }
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() { return firstName; }
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() { return lastName; }
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() { return age; }
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public char getGender() { return gender; }
	
	public void setSsN(long ssN) {
		this.ssN = ssN;
	}
	
	public long getSsN() { return ssN; }
	
	public void setCity(String city) {
		this.cityOfResidence = city;
	}
	
	public String getCity() { return cityOfResidence; }
	
	public void setCountry(String country) {
		this.countryOfResidence = country;
	}
	
	public String getCountry() { return countryOfResidence; }
	
}
