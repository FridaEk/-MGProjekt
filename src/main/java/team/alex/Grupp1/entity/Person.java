package team.alex.Grupp1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Column(name="firstname")
	String firstName;

	@Column(name="lastname")
	String lastName;

	@Column(name="age")
	int age;
	
	@Column(name="gender")
	char gender;
	
	@Id
	@Column(name="SSN")
	long ssN;

	@Column(name="city")
	String cityOfResidence;

	@Column(name="country")
	String countryOfResidence;
	
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
