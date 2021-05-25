package model;

import java.util.ArrayList;
import java.util.List;

public class Resident extends Person {
	
	int residentId;
	int apartmentNumber;
	String streetName;
	int houseNumber;
	ZipCity city;
	List<Residency> residencies;
	

	public Resident(String fname, String lname, String ssn, String phoneNumber, String email, int apartmentNumber, String streetName, int houseNumber, ZipCity zipCity) {
		
		super(fname, lname, ssn, phoneNumber, email);
		this.apartmentNumber = apartmentNumber;
		this.streetName = streetName;
		this.houseNumber = houseNumber; 
		this.city = zipCity;
		residencies = new ArrayList<>();
	}
	
	public void addResidency(Residency residency) {
		residencies.add(residency);
	}
	
	public void setResidencyList(List<Residency> residencyList) {
		residencies = residencyList;
	}
	
	public List<Residency> getResidencyList(){
		return residencies;
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
