package model;

public class Employee extends Person {

	private int employeeNumber;

	public Employee(int employeeNumber, String fname, String lname, String ssn, String phoneNumber, String email) {
		super(fname, lname, ssn, phoneNumber, email);
		this.employeeNumber = employeeNumber;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

}