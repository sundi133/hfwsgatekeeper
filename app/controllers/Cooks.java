package controllers;

public class Cooks {
	long[] dishIds;
	String name;
	int age;
	String picImage;
	String address;
	String city;
	String country;
	int pinCode;
	long bankAccountId;
	long phoneNumber;
	String emailId;
	int cookRating;
	String[] cookRatingComments;
	long[] consumersRated;
	
	
	int[] availDays = new int[7];
	int[][] availHours = new int[24][7];
	
	public long[] getDishIds() {
		return dishIds;
	}
	public void setDishIds(long[] dishIds) {
		this.dishIds = dishIds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPicImage() {
		return picImage;
	}
	public void setPicImage(String picImage) {
		this.picImage = picImage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public long getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int[] getAvailDays() {
		return availDays;
	}
	public void setAvailDays(int[] availDays) {
		this.availDays = availDays;
	}
	public int[][] getAvailHours() {
		return availHours;
	}
	public void setAvailHours(int[][] availHours) {
		this.availHours = availHours;
	}
	public int getCookRating() {
		return cookRating;
	}
	public void setCookRating(int cookRating) {
		this.cookRating = cookRating;
	}
	public String[] getCookRatingComments() {
		return cookRatingComments;
	}
	public void setCookRatingComments(String[] cookRatingComments) {
		this.cookRatingComments = cookRatingComments;
	}
	public long[] getConsumersRated() {
		return consumersRated;
	}
	public void setConsumersRated(long[] consumersRated) {
		this.consumersRated = consumersRated;
	}
	
}
