package model;

public class Resident extends Person {
	
	int residentId;
	int apartmentNumber;
	String streetName;
	int houseNumber;
	ZipCity city; 
	

	public Resident(String fname, String lname, String ssn, String phoneNumber, String email, int apartmentNumber, String streetName, int houseNumber, ZipCity zipCity) {
		
		super(fname, lname, ssn, phoneNumber, email);
		this.apartmentNumber = apartmentNumber;
		this.streetName = streetName;
		this.houseNumber = houseNumber; 
		this.city = zipCity;
	}
	
	public int getResidentId() {
		return residentId;
	}
	
	public void setId(int id) {
		this.id = id;
		
	}

	public ZipCity getZipCity() {
		// TODO Auto-generated method stub
		return city;
	}
		
		
	
}
