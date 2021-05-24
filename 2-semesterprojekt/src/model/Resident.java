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
		residentId = id;
	}

	public ZipCity getZipCity() {
		// TODO Auto-generated method stub
		return city;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public int getHouseNumber() {
		return houseNumber;
	}
		
		
	
}
