package application.controller;

import application.model.entity.Bike;
import application.model.services.BikeService;
/**
 * This class used to control view bike related action
 * @author anhtnguyen
 *
 */
public class ViewBikeController {
	private BikeService bikeServiceHandler;
	/**
	 * Constructor of the class
	 */
	public ViewBikeController() {
		this.bikeServiceHandler = new BikeService();
	}
	/**
	 * This method get the information of the bike
	 * @param id
	 * @return Bike
	 */
	public Bike getBikeInfo(String id) {
		return this.bikeServiceHandler.getBikeInfo(id);
		
	}
}
