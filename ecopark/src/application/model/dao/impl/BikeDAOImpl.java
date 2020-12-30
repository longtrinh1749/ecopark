package application.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import application.model.dao.BikeDAO;
import application.model.entity.Bike;
import application.utils.db.DBConnection;


public class BikeDAOImpl implements BikeDAO {
	public static final String QUERY_SELECT_ALL = "Select * from bike where dockId = ? ";
	public static final String QUERY_SELECT_BY_ID = "Select * from bike where id LIKE ? ";
	public static final String QUERY_INSERT = "insert into bike values(?,?,?)";
	public static final String QUERY_UPDATE_DOCK_ID_BY_ID = "update bike set dockId = ? where id = ?";
	public static final String QUERY_DELETE_BY_ID = "delete from bike where id = ?";
	
	private Connection conn;
	PreparedStatement pstm;
	Bike bike;
	
	public BikeDAOImpl() {
		try {
			conn = DBConnection.openConnection();
			System.out.println("Connect to DB.");
		} catch (SQLException e) {
			System.out.println("Error Connecting to DB.");
			e.printStackTrace();
		}
	}
	
	public List<Bike> getAll(int dockId) {
		String sql = QUERY_SELECT_ALL;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, dockId);
			ResultSet rs = pstm.executeQuery();
			List<Bike> bikeList = new ArrayList<Bike>();

			while (rs.next()) {
				Bike bike = get(rs.getString(1));
				bikeList.add(bike);	
				return bikeList;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		return null;
	}
	
	public Bike get(String id) {
		String sql = QUERY_SELECT_BY_ID;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			Bike bike;
			while (rs.next()) {
				bike = new Bike();
				bike.setId(rs.getString(1));
				bike.setBatteryStatus(rs.getInt(2));
				bike.setImageURL(rs.getString(5));
				bike.setType(rs.getInt(4));
				return bike;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		return null;
	}
	
	public int updateDockId(String bikeid, int dockid) {
		String sql = QUERY_UPDATE_DOCK_ID_BY_ID;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, dockid);
			pstm.setString(2, bikeid);
			int rowAffect = pstm.executeUpdate();
			return rowAffect;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public int updateNullDockId(String bikeid) {
		String sql = "update bike set dockId = null where id = ?;";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bikeid);
			int rowAffect = pstm.executeUpdate();
			return rowAffect;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
