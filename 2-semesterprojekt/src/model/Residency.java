package model;

import java.time.LocalDate;
import java.util.Date;

public class Residency {

	private int id;
	private LocalDate fromDate;
	private LocalDate toDate;
	private Municipality municipality; 
	private Resident resident;
	
	public Residency(int id, LocalDate fromDate, LocalDate toDate) {
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public Residency(int id, LocalDate fromDate, LocalDate toDate, Resident resident, Municipality municipality) {
		this(id, fromDate, toDate);
		this.municipality = municipality;
		this.resident = resident;
		
	}
	
	
	
	
	public LocalDate getFromDate() {
		return fromDate;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
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


