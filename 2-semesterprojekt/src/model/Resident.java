package model;

public class Resident extends Person {

	int apartmentNumber;
	String streetName;
	int houseNumber;

	public Resident(int apartmentNumber, String streetName, int houseNumber, String ssn, String fname, String lname,
			String phoneNumber, String email) {
		super(fname, lname, ssn, phoneNumber, email);

		this.apartmentNumber = apartmentNumber;
		this.streetName = streetName;
		this.houseNumber = houseNumber;
	}

}
