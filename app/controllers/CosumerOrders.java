package controllers;

public class CosumerOrders {
	long consumerId;
	long[] dishId;
	long orderTime;
	
	public long getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
	}
	public long[] getDishId() {
		return dishId;
	}
	public void setDishId(long[] dishId) {
		this.dishId = dishId;
	}
	public long getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}
	
	
}
