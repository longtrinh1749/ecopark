package application.model.entity;

import java.util.Date;

public class Order {
	
	private static Order orderInstance;
	
	private Bike bike;
	private CreditCard card;
	private Date rentStartTime;
	
	public static Order getOrder() {
		if (orderInstance == null) orderInstance = new Order();
		return orderInstance;
	}
	public boolean checkRentedBike() {
		if (orderInstance.getBike() == null ) return false;
		else return true;
	}
	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}
	
	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	public Date getRentStartTime() {
		return rentStartTime;
	}

	public void setRentStartTime(Date rentStartTime) {
		this.rentStartTime = rentStartTime;
	}
	public void setRentStartTime() {
		Date date = new Date();
		this.rentStartTime = date;
	}
	//clear order after payment and save invoice to database
	public void clearOrder() {
		orderInstance = new Order();
	}
}
