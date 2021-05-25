package model;

import java.util.Date;

public class Residency {

	private int id;
	private Date fromDate;
	private Date toDate;
	private Municipality municipality; 
	private Resident resident;
	
	public Residency(int id, Date fromDate, Date toDate, Municipality municipality, Resident resident) {
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.municipality = municipality;
		this.resident = resident;
		
	}
	
	
	public Date getFromDate() {
		return fromDate;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Municipality getMunicipality() {
		return municipality;
	}
	public void setMunicipality(Municipality municipality) {
		this.municipality = municipality;
	}
	public Resident getResident() {
		return resident;
	}
	public void setResident(Resident resident) {
		this.resident = resident;
	} 
	
	

}


