package application.model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * This class represent the invoice entity
 * @author tungnt
 * @version 1.0
 *
 */
public class Invoice {
	
	private Bike bike;
	private CreditCard card;
	private Date rentStartTime;
	private Date rentEndTime;
	private double total;
	
	/**
	 * This function get the rental duration in minutes 
	 * @return rental duration in minutes
	 */
	long getDuration() {
		long diff =rentEndTime.getTime() - rentStartTime.getTime();
		long minutesDiff = TimeUnit.MILLISECONDS.toMinutes(diff);
		return minutesDiff;
	}
	
	/**
	 * This function return the duration in String to pass to invoice screen
	 * @return String duration
	 */
	public String getStringDuration() {
		String stringDuration = Long.toString(getDuration()) + " minutes";
		return stringDuration;
	}
	
	/**
	 * This function return the cost in string to pass to invoice screen
	 * @return String cost
	 */
	public String getStringCost() {
		String stringCost = Double.toString(total) + " vnd";
		return stringCost;
	}
	
	public double getTotal() {
		  return this.total;
	}
	
	public Bike getBike() {
		return bike;
	}
	
	// a test function to test the calculate cost func 
	double calculateCostTest() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		String start = "20/12/13 10:35:26";
		String end = "20/12/13 11:35:26";
		Date startDate = format.parse(start);
		Date endDate = format.parse(end);
		double cost = 0;
		long diff = startDate.getTime() - endDate.getTime();
		long minutesDiff = TimeUnit.MILLISECONDS.toMinutes(diff);
		if ( minutesDiff >= 10 && minutesDiff <=30  ) cost = 10;
		if ( minutesDiff > 30 ) cost = (int) (10000 + (Math.ceil(( minutesDiff - 30.0 )/15))*3000);
		return cost;
	}
	
	/**
	 * This function return the rent time in string to pass to invoice screen
	 * @return String rent time
	 */
	public String getStringRentStartTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		String stringRentStartTime = formatter.format(rentStartTime);
		return stringRentStartTime;
	}
	
	/**
	 * This function return the return time in string to pass to invoice screen
	 * @return String return time
	 */
	public String getStringEndTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		String stringEndTime = formatter.format(rentEndTime);
		return stringEndTime;
	}
	
	public Invoice(Bike bike, CreditCard card, Date rentStartTime, double total) {
		this.bike = bike; 
		this.card = card;
		this.rentStartTime = rentStartTime;
		this.total = total;
		Date rentEndTime = new Date();
		this.rentEndTime = rentEndTime;
	}
}
