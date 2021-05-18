package model;

public class Resident extends Person {
	
	int id;
	int apartmentNumber;
	int adressId;
	
	
	public Resident(String ssn, int apartmentNumber, String fname, String lname, String phoneNr, String email, int addressId ) {
		super(fname, lname, ssn, phoneNr, email);
		
		this.apartmentNumber = apartmentNumber;
		this.adressId = addressId;
	}


	public void setId(int int1) {
		// TODO Auto-generated method stub
		id = int1;
	}
	 
	
	
	
	
}
