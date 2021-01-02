package application.model.services;

import application.model.entity.Order;

public interface PaymentServiceInterface {
	public Double calculateCost(Order order);
}
