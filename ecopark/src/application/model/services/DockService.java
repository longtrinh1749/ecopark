package application.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.dao.DockDAO;
import application.model.dao.impl.DockDAOImpl;
import application.model.entity.Dock;

public class DockService implements DockServiceInterface{
	
	DockDAO dockDAO;
	
	public DockService() {
		dockDAO = new DockDAOImpl();
	}
	
	public List<Dock> getDockList() {
		return dockDAO.getAll();
	}
	
	public Dock getDockInfo(int id) {
		return dockDAO.get(id);
	}
	
	public List<Dock> getDockListByAddress(String address) {
		return dockDAO.getByAddress(address);
	}
	
	public int getEmptyParkingLot(int dockId) {
		int occupiedLot = dockDAO.getNumberOccupiedBike(dockId);
		Dock dock = getDockInfo(dockId);
		return dock.getArea() - occupiedLot;
	}
	public int getNumOfBike(int dockId) {
		return dockDAO.getNumberOccupiedBike(dockId);
	}
	public List<Dock> getAvailableDockForReturnBike() {
		return dockDAO.getAvailableDockForReturnBike();
	}
}
