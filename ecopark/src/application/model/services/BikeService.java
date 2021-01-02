package application.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import application.model.dao.BikeDAO;
import application.model.dao.DockDAO;
import application.model.dao.impl.BikeDAOImpl;
import application.model.entity.Bike;
import application.model.entity.Dock;

public class BikeService implements BikeServiceInterface {
	BikeTypeService bikeTypeService;
	BikeDAO bikeDAO;
	
	public BikeService() {
		bikeTypeService = new BikeTypeService();
		bikeDAO = new BikeDAOImpl();
	}
	
	public List<Bike> getBikeList(int dockId) {
		return bikeDAO.getAll(dockId);
	}
	
	public Bike getBikeInfo(String id) { 
		Bike bike = bikeDAO.get(id);
		if(bike != null) {
			Map<String, Object> m = bikeTypeService.getBikeTypeById(bike.getType());
			bike.setTypeName((String) m.get("typename"));
			bike.setDepositValue((double) m.get("typevalue"));
			bike.setPayFactor((double) m.get("typepayfactor"));
		}
		return bike;
	}

	public int updateDockIdByRentBike(String bikeId) {
		int rs = bikeDAO.updateNullDockId(bikeId);
		return rs;
	}
	
	public int updateDockIdByReturnBike(String bikeId, int dockId) {
		int rs = bikeDAO.updateDockId(bikeId, dockId);
		return rs;
	}
}