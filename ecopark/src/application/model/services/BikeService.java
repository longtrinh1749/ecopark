package application.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import application.model.dao.BikeDAO;
import application.model.dao.DockDAO;
import application.model.entity.Bike;
import application.model.entity.Dock;

public class BikeService extends BaseService {
	BikeTypeService bikeTypeService;
	BikeDAO bikeDAO;
	
	public BikeService() {
		bikeTypeService = new BikeTypeService();
		bikeDAO = new BikeDAO();
	}
	
	public List<Bike> getBikeList(int dockId) {
		List<Bike> bikeList = new ArrayList<Bike>();
		ResultSet rs = bikeDAO.getAllBike(dockId);
		try {
			while (rs.next()) {
				Map<String, Object> m = bikeTypeService.getBikeTypeById(rs.getInt(4));
//				Bike bike = new Bike(rs.getString(1), (String) m.get("typename"), (double) m.get("typevalue"), rs.getString(5));
				Bike bike = getBikeInfo(rs.getString(1));
				bikeList.add(bike);
				System.out.println(bike.getBatteryStatus());
			}
			return bikeList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Bike getBikeInfo(String id) {
		ResultSet rs = bikeDAO.getBikeById(id);
		Bike bike;
		try {
			while (rs.next()) {
				Map<String, Object> m = bikeTypeService.getBikeTypeById(rs.getInt(4));
				if (m != null) {
					bike = new Bike(rs.getString(1), (String) m.get("typename"), (double) m.get("typevalue"), rs.getInt(2),
							rs.getString(5), (double) m.get("typepayfactor"));
					System.out.println(bike.getTypeName());
					return bike;
				}
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int updateDockIdByRentBike(String bikeId) throws SQLException {
		int rs = bikeDAO.updateBikeDockIdByRentBike(bikeId);
		return rs;
	}
	
	public int updateDockIdByReturnBike(String bikeId, int dockId) {
		int rs = bikeDAO.updateBikeDockId(bikeId, dockId);
		return rs;
	}
}