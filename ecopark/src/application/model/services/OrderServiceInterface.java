package application.model.services;

import application.model.entity.Order;

public interface OrderServiceInterface {
	public Order getAccountOrder(String accountId);
	public boolean saveOrder(Order order);
	public boolean clearOrder(Order order);
}
