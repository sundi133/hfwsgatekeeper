package controllers.utils;

public class Location {

	String name;
	String pin;
	String state;
	String district;
	
	
	public Location(String name, String pin, String state, String district) {
		super();
		this.name = name;
		this.pin = pin;
		this.state = state;
		this.district = district;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
}
