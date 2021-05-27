package model;

import java.util.ArrayList;
import java.util.List;

public class Resident extends Person {

	private int residentId;
	private int apartmentNumber;
	private String streetName;
	private int houseNumber;
	private ZipCity zipCity;
	private List<Residency> residencies;

	public Resident(String fname, String lname, String ssn, String phoneNumber, String email, int apartmentNumber,
			String streetName, int houseNumber) {

		super(fname, lname, ssn, phoneNumber, email);
		this.apartmentNumber = apartmentNumber;
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		residencies = new ArrayList<>();
	}

	public void addResidency(Residency residency) {
		residencies.add(residency);
	}

	public void setResidencyList(List<Residency> residencyList) {
		residencies = residencyList;
	}

	public List<Residency> getResidencyList() {
		return residencies;
	}

	public int getResidentId() {
		return residentId;
	}

	public void setId(int id) {
		residentId = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public ZipCity getZipCity() {
		// TODO Auto-generated method stub
		return zipCity;
	}
	
	public void setZipCity(ZipCity city) {
		this.zipCity = city;
	}

}
