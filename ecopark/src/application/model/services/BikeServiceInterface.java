package application.model.services;

import java.util.List;

import application.model.entity.Bike;

public interface BikeServiceInterface {
	public List<Bike> getBikeList(int dockId);
	public Bike getBikeInfo(String id);
	public int updateDockIdByRentBike(String bikeId);
	public int updateDockIdByReturnBike(String bikeId, int dockId);
}
