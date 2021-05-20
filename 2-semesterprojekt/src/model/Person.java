package model;

public class Person {

	private String fname;
	private String lname;
	private String ssn;
	private String phoneNumber;
	private String email;

	public Person(String fname, String lname, String ssn, String phoneNumber, String email) {
		this.fname = fname;
		this.lname = lname;
		this.ssn = ssn;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
