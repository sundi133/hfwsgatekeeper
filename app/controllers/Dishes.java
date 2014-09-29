package controllers;

public class Dishes {
	long dishId;
	long cookId;
	String dishName;
	String dishDescription;
	String dishCost;
	int[][] dishServedTimes = new int[7][24];
	String dishMetadata;
	String dishPic;
	String dishRating;
	String[] comments;
	long[] consumersRated;
	public long getDishId() {
		return dishId;
	}
	public void setDishId(long dishId) {
		this.dishId = dishId;
	}
	public long getCookId() {
		return cookId;
	}
	public void setCookId(long cookId) {
		this.cookId = cookId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getDishDescription() {
		return dishDescription;
	}
	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}
	public String getDishCost() {
		return dishCost;
	}
	public void setDishCost(String dishCost) {
		this.dishCost = dishCost;
	}
	public int[][] getDishServedTimes() {
		return dishServedTimes;
	}
	public void setDishServedTimes(int[][] dishServedTimes) {
		this.dishServedTimes = dishServedTimes;
	}
	public String getDishMetadata() {
		return dishMetadata;
	}
	public void setDishMetadata(String dishMetadata) {
		this.dishMetadata = dishMetadata;
	}
	public String getDishPic() {
		return dishPic;
	}
	public void setDishPic(String dishPic) {
		this.dishPic = dishPic;
	}
	public String getDishRating() {
		return dishRating;
	}
	public void setDishRating(String dishRating) {
		this.dishRating = dishRating;
	}
	public String[] getComments() {
		return comments;
	}
	public void setComments(String[] comments) {
		this.comments = comments;
	}
	public long[] getConsumersRated() {
		return consumersRated;
	}
	public void setConsumersRated(long[] consumersRated) {
		this.consumersRated = consumersRated;
	}
	
	
}
