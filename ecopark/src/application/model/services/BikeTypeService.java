package application.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import application.model.dao.BikeTypeDAO;
import application.model.dao.impl.BikeTypeDAOImpl;

public class BikeTypeService implements BikeTypeServiceInterface{
	BikeTypeDAO bikeTypeDAO;
	
	public BikeTypeService() {
		this.bikeTypeDAO = new BikeTypeDAOImpl();
	}
	
	public Map<String, Object> getBikeTypeById(int id) {
		return bikeTypeDAO.getBikeTypeById(id);
	}
}
