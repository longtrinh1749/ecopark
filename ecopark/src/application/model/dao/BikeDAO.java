package application.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.db.DBConnection;


public class BikeDAO {
	public static final String QUERY_SELECT_ALL = "Select * from bike where dockId = ? ";
	public static final String QUERY_SELECT_BY_ID = "Select * from bike where id LIKE ? ";
	public static final String QUERY_INSERT = "insert into bike values(?,?,?)";
	public static final String QUERY_UPDATE_DOCK_ID_BY_ID = "update bike set dockId = ? where id = ?";
	public static final String QUERY_DELETE_BY_ID = "delete from bike where id = ?";
	
	private Connection conn;
	PreparedStatement pstm;
	
	public BikeDAO() {
		try {
			conn = DBConnection.openConnection();
			System.out.println("Connect to DB.");
		} catch (SQLException e) {
			System.out.println("Error Connecting to DB.");
			e.printStackTrace();
		}
	}
	
	public ResultSet getAllBike(int dockId) {
		String sql = QUERY_SELECT_ALL;
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
	
	public ResultSet getBikeById(String id) {
		String sql = QUERY_SELECT_BY_ID;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public int updateBikeDockId(String bikeid, int dockid) {
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
	
	public int updateBikeDockIdByRentBike(String bikeid) {
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
