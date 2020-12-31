package application.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.dao.DockDAO;
import application.model.entity.Dock;
import application.utils.db.DBConnection;

public class DockDAOImpl implements DockDAO {
	public static final String QUERY_SELECT_ALL = "Select * from dock ";
	public static final String QUERY_SELECT_BY_ID = "Select * from dock where id = ?";
	public static final String QUERY_SELECT_BY_ADDRESS = "Select * from dock where address LIKE ?";
	public static final String QUERY_INSERT = "insert into dock values(?,?,?)";
	public static final String QUERY_UPDATE_BY_ID = "update dock set username = ?, password = ? where id = ?";
	public static final String QUERY_DELETE_BY_ID = "delete from dock where id = ?";
	
	private Connection conn;
	PreparedStatement pstm;
	Dock dock;
	List<Dock> dockList = new ArrayList<Dock>();
	
	public DockDAOImpl() {
		try {
			conn = DBConnection.openConnection();
			System.out.println("Connect to DB.");
		} catch (SQLException e) {
			System.out.println("Error Connecting to DB.");
			e.printStackTrace();
		}
	}
	
	public List<Dock> getAll() {
		String sql = QUERY_SELECT_ALL;
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Dock dock = new Dock(rs.getInt(1), rs.getString(6));
				int id = dock.getId();
				int bikeNum = getNumberOccupiedBike(id);
				dock.setBikeNum(bikeNum);
				dockList.add(dock);
			}
			return dockList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public Dock get(int id) {
		String sql = QUERY_SELECT_BY_ID;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
			    dock = new Dock(rs.getInt(1), rs.getString(5), rs.getString(6), rs.getInt(3), rs.getInt(4));
				int bikeNum = getNumberOccupiedBike(id);
				dock.setBikeNum(bikeNum);
			    return dock;
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		return null;
	}
	
	public List<Dock> getByAddress(String address) {
		String sql = QUERY_SELECT_BY_ADDRESS;
		dockList = new ArrayList<Dock>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + address + "%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Dock dock = new Dock(rs.getInt(1), rs.getString(6));
				dockList.add(dock);
			}
			return dockList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public int getNumberOccupiedBike(int dockId) {
		String sql = "select count(*) from bike where dockId = ?";
		int occupiedLot;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, dockId);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				occupiedLot = rs.getInt(1);
				return occupiedLot;
			} else return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<Dock> getAvailableDockForReturnBike() {
		String sql = "select * from dock where (select count(*) from bike where dockId = dock.id) < dock.area;";
		dockList = new ArrayList<Dock>();
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int a = rs.getInt(1);
				System.out.println(a);
				String b = rs.getString(6);
				System.out.println(b);
				Dock dock = new Dock(a, b);
				System.out.println(dock.getAddress());
				dockList.add(new Dock(a, b));
			}
			return dockList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
}
