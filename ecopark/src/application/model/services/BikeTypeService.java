package application.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import application.model.dao.BikeTypeDAO;

public class BikeTypeService {
	BikeTypeDAO bikeTypeDAO;
	
	public BikeTypeService(BikeTypeDAO bikeTypeDAO) {
		this.bikeTypeDAO = bikeTypeDAO;
	}
	
	public Map<String, Object> getBikeTypeById(int id) {
		return bikeTypeDAO.getBikeTypeById(id);
	}
}
