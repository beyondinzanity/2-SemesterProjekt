package model;


public class ZipCity {

	private String postalCode;
	private String city;
	private int id;
	
	public ZipCity(String postalCode, String city) {
		this.postalCode = postalCode;
		this.city = city;
		
	}
	
	public String getCity() {
		return city;
	}

	public void setId(int id) {
		this.id = id;
		
	}

}
