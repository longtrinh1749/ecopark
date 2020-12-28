package application.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.dao.DockDAO;
import application.model.entity.Dock;

public class DockService {
	
	DockDAO dockDAO;
	
	public DockService() {
		dockDAO = new DockDAO();
	}
	
	public List<Dock> getDockList() {
		List<Dock> dockList = new ArrayList<Dock>();
		ResultSet rs = dockDAO.getAllDock();
		try {
			while (rs.next()) {
				Dock dock = new Dock(rs.getInt(1), rs.getString(6));
				int id = dock.getId();
				int bikeNum = getNumOfBike(id);
				dock.setBikeNum(bikeNum);
				dockList.add(dock);
				System.out.println(dock.getAddress());
			}
			return dockList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Dock getDockInfo(int id) {
		ResultSet rs = dockDAO.getDockById(id);
		Dock dock;
		try {
		  while (rs.next()) {
		    dock = new Dock(rs.getInt(1), rs.getString(5), rs.getString(6), rs.getInt(3), rs.getInt(4));
			int bikeNum = getNumOfBike(id);
			dock.setBikeNum(bikeNum);
		    return dock;
		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public List<Dock> getDockListByAddress(String address) {
		List<Dock> dockList = new ArrayList<Dock>();
		ResultSet rs = dockDAO.getDockByAddress(address);
		try {
			while (rs.next()) {
				Dock dock = new Dock(rs.getInt(1), rs.getString(6));
				dockList.add(dock);
				System.out.println(dock.getAddress());
			}
			return dockList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public int getEmptyParkingLot(int dockId) {
		int occupiedLot;
		ResultSet rs = dockDAO.getNumberOccupiedBike(dockId);
		Dock dock = getDockInfo(dockId);
		try {
			if(rs.next()) {
				occupiedLot = rs.getInt(1);
			} else return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return dock.getArea() - occupiedLot;
	}
	public int getNumOfBike(int dockId) {
		int occupiedLot;
		ResultSet rs = dockDAO.getNumberOccupiedBike(dockId);
		try {
			if(rs.next()) {
				occupiedLot = rs.getInt(1);
			} else return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return occupiedLot;
	}
	public List<Dock> getAvailableDockForReturnBike() {
		List<Dock> dockList = new ArrayList<Dock>();
		ResultSet rs = dockDAO.getAvailableDockForReturnBike();
		try {
			while (rs.next()) {
				Dock dock = new Dock(rs.getInt(1), rs.getString(6));
				dockList.add(dock);
				System.out.println(dock.getAddress());
			}
			return dockList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
