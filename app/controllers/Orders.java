package controllers;

public class Orders {
	long[] dishIds;
	long consumerId;
	long time;
	
	public long[] getDishIds() {
		return dishIds;
	}
	public void setDishIds(long[] dishIds) {
		this.dishIds = dishIds;
	}
	public long getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
}
