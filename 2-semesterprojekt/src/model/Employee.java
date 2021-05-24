package model;

public class Employee extends Person {

	private int employeeId;
	private int employeeNumber;
	

	public Employee(int employeeNumber, String fname, String lname, String ssn, String phoneNumber, String email) {
		super(fname, lname, ssn, phoneNumber, email);
		this.employeeNumber = employeeNumber;
	}
	
	public Employee(int employeeId, int employeeNumber, String fname, String lname, String ssn, String phoneNumber, String email) {
		this(employeeNumber, fname, lname, ssn, phoneNumber, email);
		this.employeeId = employeeId;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	public int getEmployeeId() {
		return employeeId;
		
	}

}