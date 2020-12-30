package application.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.dao.OrderDAO;
import application.model.entity.Bike;
import application.model.entity.Order;
import application.utils.db.DBConnection;

public class OrderDAOImpl implements OrderDAO {
	
	private Connection conn;
	PreparedStatement pstm;
	
	public OrderDAOImpl() {
		try {
			conn = DBConnection.openConnection();
			System.out.println("Connect to DB.");
		} catch (SQLException e) {
			System.out.println("Error Connecting to DB.");
			e.printStackTrace();
		}
	}
	
	@Override
	public Order get(String accountId) {
		String sql = "select * from AccountOrder where accountid = " + accountId;
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public boolean insert(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

}
