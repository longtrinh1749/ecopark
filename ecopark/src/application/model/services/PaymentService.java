package application.model.services;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import application.model.entity.Order;

public class PaymentService implements PaymentServiceInterface {

	@Override
	public Double calculateCost(Order order) {
		Date now = new Date();
		double cost = 0;
		
		long diff = now.getTime() - order.getRentStartTime().getTime();
		long minutesDiff = TimeUnit.MILLISECONDS.toMinutes(diff);
		if ( minutesDiff >= 10 && minutesDiff <=30  ) cost = 10;
		if ( minutesDiff > 30 ) cost = (int) (10000 + (Math.ceil(( minutesDiff - 30.0 )/15))*3000);
		double amount = order.getBike().getPayFactor()*cost;
		return amount;
	}
	
}
