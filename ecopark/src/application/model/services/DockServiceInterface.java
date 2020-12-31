package application.model.services;

import java.util.List;

import application.model.entity.Dock;

public interface DockServiceInterface {
	public List<Dock> getDockList();
	public Dock getDockInfo(int id);
	public List<Dock> getDockListByAddress(String address);
	public int getEmptyParkingLot(int dockId);
	public int getNumOfBike(int dockId);
	public List<Dock> getAvailableDockForReturnBike();
}
