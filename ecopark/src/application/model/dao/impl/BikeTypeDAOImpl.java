package application.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import application.model.dao.BikeTypeDAO;
import application.utils.db.DBConnection;

public class BikeTypeDAOImpl implements BikeTypeDAO{
	public static final String QUERY_SELECT_ALL = "Select * from type ";
	public static final String QUERY_SELECT_BY_ID = "Select * from type where id = ?";
	public static final String QUERY_INSERT = "insert into type values(?,?,?)";
	public static final String QUERY_UPDATE_BY_ID = "update type set username = ?, password = ? where id = ?";
	public static final String QUERY_DELETE_BY_ID = "delete from type where id = ?";
	
	private Connection conn;
	PreparedStatement pstm;
	
	public BikeTypeDAOImpl() {
		try {
			conn = DBConnection.openConnection();
			System.out.println("Connect to DB.");
		} catch (SQLException e) {
			System.out.println("Error Connecting to DB.");
			e.printStackTrace();
		}
	}
	
	public Map<String, Object> getBikeTypeById(int id) {
		String sql = QUERY_SELECT_BY_ID;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			Map<String, Object> m = new HashMap<String, Object>();
			while (rs.next()) {
				m.put("typeid", rs.getInt(1));
				m.put("typename", rs.getString(2));
				m.put("typevalue", rs.getDouble(3));
				m.put("typepayfactor", rs.getDouble(4));
				m.put("typedescription", rs.getString(5));
			}
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
