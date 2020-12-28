package application.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.utils.db.DBConnection;

public class BikeTypeDAO {
	public static final String QUERY_SELECT_ALL = "Select * from type ";
	public static final String QUERY_SELECT_BY_ID = "Select * from type where id = ?";
	public static final String QUERY_INSERT = "insert into type values(?,?,?)";
	public static final String QUERY_UPDATE_BY_ID = "update type set username = ?, password = ? where id = ?";
	public static final String QUERY_DELETE_BY_ID = "delete from type where id = ?";
	
	private Connection conn;
	PreparedStatement pstm;
	
	public BikeTypeDAO() {
		try {
			conn = DBConnection.openConnection();
			System.out.println("Connect to DB.");
		} catch (SQLException e) {
			System.out.println("Error Connecting to DB.");
			e.printStackTrace();
		}
	}
	
	public ResultSet getBikeTypeById(int id) {
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
}
