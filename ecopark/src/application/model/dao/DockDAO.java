package application.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.utils.db.DBConnection;

public class DockDAO {
	public static final String QUERY_SELECT_ALL = "Select * from dock ";
	public static final String QUERY_SELECT_BY_ID = "Select * from dock where id = ?";
	public static final String QUERY_SELECT_BY_ADDRESS = "Select * from dock where address LIKE ?";
	public static final String QUERY_INSERT = "insert into dock values(?,?,?)";
	public static final String QUERY_UPDATE_BY_ID = "update dock set username = ?, password = ? where id = ?";
	public static final String QUERY_DELETE_BY_ID = "delete from dock where id = ?";
	
	private Connection conn;
	PreparedStatement pstm;
	
	public DockDAO() {
		try {
			conn = DBConnection.openConnection();
			System.out.println("Connect to DB.");
		} catch (SQLException e) {
			System.out.println("Error Connecting to DB.");
			e.printStackTrace();
		}
	}
	
	public ResultSet getAllDock() {
		String sql = DockDAO.QUERY_SELECT_ALL;
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public ResultSet getDockById(int id) {
		String sql = QUERY_SELECT_BY_ID;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public ResultSet getDockByAddress(String address) {
		String sql = QUERY_SELECT_BY_ADDRESS;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + address + "%");
			ResultSet rs = pstm.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public ResultSet getNumberOccupiedBike(int dockId) {
		String sql = "select count(*) from bike where dockId = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, dockId);
			ResultSet rs = pstm.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public ResultSet getAvailableDockForReturnBike() {
		String sql = "select * from dock where (select count(*) from bike where dockId = dock.id) < dock.area;";
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
}
