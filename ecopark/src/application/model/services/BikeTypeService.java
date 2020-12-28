package application.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import application.model.dao.BikeTypeDAO;

public class BikeTypeService {
	BikeTypeDAO bikeTypeDAO;
	
	public BikeTypeService() {
		bikeTypeDAO = new BikeTypeDAO();
	}
	
	public Map<String, Object> getBikeTypeById(int id) {
		ResultSet rs = bikeTypeDAO.getBikeTypeById(id);
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			while (rs.next()) {
				m.put("typeid", rs.getInt(1));
				m.put("typename", rs.getString(2));
				m.put("typevalue", rs.getDouble(3));
				m.put("typepayfactor", rs.getDouble(4));
				m.put("typedescription", rs.getString(5));
			}
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
