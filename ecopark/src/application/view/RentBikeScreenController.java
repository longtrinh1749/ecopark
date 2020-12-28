package application.view;

import java.io.IOException;

import application.controller.RentBikeController;
import application.model.entity.Bike;
import application.model.services.BikeService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *@author tungnt
 *@version 1.0
 *This class used to control the rent bike screen
 */
public class RentBikeScreenController {

	@FXML
	private TextField bikeId;
	@FXML
	private Button home;
	@FXML
	private Button rentBike;
/**
 * This function is used to get the rent bike id and show payment screen  	
 * @throws IOException 
 */
	public void handleRentBikeClick() throws IOException { 
		BikeService bikeservice = new BikeService();
        Bike bike = bikeservice.getBikeInfo(bikeId.getText());
        // if successfully get the bike from DB then continue
        if (bike != null ) {
        	RentBikeController rentbikecontroller = new RentBikeController();
        	rentbikecontroller.setBike(bike);
        	
        	//change to payment screen
    	    Stage stage;
    	    Parent root;
    	    stage = (Stage) rentBike.getScene().getWindow();
    	    root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/PaymentScreen.fxml"));
    	    Scene scene = new Scene(root);
    	    stage.setScene(scene);
    	    stage.setTitle("Payment");
    	    stage.show();
        }
        else Popup.display("Error", "Invalid Bike ID");;
        
	}
	/** 
	 * This function is used to change to Home Screen
	 * @throws IOException
	 */
	public void handleHomeClick() throws IOException {
		//change to home screen
	    Stage stage;
	    Parent root;
	    stage = (Stage) home.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/HomeScreen.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.setTitle("EcoBikeRental");
	    stage.show();
	}
}
