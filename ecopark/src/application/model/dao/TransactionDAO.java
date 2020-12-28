package application.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import application.db.DBConnection;
import application.model.entity.CreditCard;

public class TransactionDAO {
	private static String QUERY_INSERT = "insert into transaction values (?, ?, ?)";
	
	private Connection conn;
	private PreparedStatement pstm;
	
	public TransactionDAO() {
		try {
			conn = DBConnection.openConnection();
		} catch (Exception e) {
			System.out.println("Cannot connect to DB - Transaction");
		}
	}
	
	public int saveTransaction(double amount, CreditCard card) {
		
		try {
			String sql = QUERY_INSERT;
			pstm.setDouble(1, amount);
			pstm.setDate(2, new Date(System.currentTimeMillis()));
			pstm.setInt(3, card.getCardId());
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
