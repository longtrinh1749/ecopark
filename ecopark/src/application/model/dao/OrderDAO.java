package application.model.dao;

import java.util.List;

import application.model.entity.Bike;
import application.model.entity.Order;

public interface OrderDAO {
	
	public Order get(String accountId);
	public boolean insert(Order order);
}
