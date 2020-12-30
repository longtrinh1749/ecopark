package application.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import application.model.entity.Dock;
import application.utils.db.DBConnection;

public interface DockDAO {
	
	public List<Dock> getAll();
	public List<Dock> getByAddress(String address);
	public Dock get(int dockId);
	public int getNumberOccupiedBike(int dockId);
	public List<Dock> getAvailableDockForReturnBike();
}
