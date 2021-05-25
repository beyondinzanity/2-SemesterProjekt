package model;

public class Municipality {
	
	private int id;
	private String name;
	private String region;

	public Municipality(int id, String name, String region) {
		this.name = name;
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
