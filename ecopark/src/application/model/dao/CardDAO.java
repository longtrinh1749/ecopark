package application.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.utils.db.DBConnection;

public class CardDAO {
	public static final String QUERY_SELECT_ALL = "Select * from card c, cardownership cos where "
			+ "cos.cardID = c.id and accountId = ? ";
	public static final String QUERY_SELECT_BY_ID = "Select * from card where id = ? ";
	public static final String QUERY_INSERT = "insert into card values(?,?,?,?)";
	public static final String QUERY_UPDATE_BY_ID = "update card set username = ?, password = ? where id = ?";
	public static final String QUERY_DELETE_BY_ID = "delete from card where id = ?";
	
	private Connection conn;
	PreparedStatement pstm;
	
	public CardDAO() {
		try {
			conn = DBConnection.openConnection();
			System.out.println("Connect to DB.");
		} catch (SQLException e) {
			System.out.println("Error Connecting to DB.");
			e.printStackTrace();
		}
	}
	
	public ResultSet getAllCard(int accountId) {
		String sql = QUERY_SELECT_ALL;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, accountId);
			ResultSet rs = pstm.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public ResultSet getCardById(String id) {
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
}
