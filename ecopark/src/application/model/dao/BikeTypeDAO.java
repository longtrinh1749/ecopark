package application.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import application.utils.db.DBConnection;

public interface BikeTypeDAO {
	
	public Map<String, Object> getBikeTypeById(int id);
}
