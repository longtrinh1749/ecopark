package application.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import application.utils.db.DBConnection;
import application.model.entity.Bike;

public interface BikeDAO {
	
	public List<Bike> getAll(int dockId);
	public Bike get(String bikeId);
	public int updateDockId(String bikeId, int dockId);
	public int updateNullDockId(String bikeId);
}
