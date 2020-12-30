package application.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import application.utils.db.DBConnection;
import application.model.entity.CreditCard;

public interface TransactionDAO {
	
	public int saveTransaction(double amount, CreditCard card);
}
