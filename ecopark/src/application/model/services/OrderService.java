package application.model.services;

import application.model.dao.OrderDAO;
import application.model.dao.impl.OrderDAOImpl;
import application.model.entity.Order;

public class OrderService implements OrderServiceInterface{
	private OrderDAO orderDAO;
	
	public OrderService() {
		orderDAO = new OrderDAOImpl();
	}
	
	public Order getAccountOrder(String accountId) {
		return orderDAO.get(accountId);
	}
	
	public boolean saveOrder(Order order) {
		return orderDAO.insert(order);
	}
	
	public boolean clearOrder(Order order) {
		return orderDAO.remove(order);
	}
}
