package application.view;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

import application.model.entity.Order;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 *@author tungnt
 *@version 0.1
 *This class used to control the home screen
 */
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class HomeScreenController{
	
    
	@FXML
	Button rentBikeButton;
	@FXML
	Button returnBikeButton;
	@FXML
	Button viewDockButton;
	@FXML 
	Button viewCurrentBikeButton;
	/**
	 *This method handle the changing to the rent bike screen
	 * @throws IOException 
	 */
	public void handleRentBikeClick() throws IOException {
		if (!Order.getOrder().checkRentedBike()) {
	    Stage stage;
	    Parent root;
	    stage = (Stage) rentBikeButton.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/RentBikeScreen.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.setTitle("Rent Bike");
	    stage.show();
		} else Popup.display("Error", "A bike is being rent");
	}
	/** 
	 * This method handle the changing to return bike screen
	 * @throws IOException
	 */
	public void handleReturnBikeClick() throws IOException {
		if (Order.getOrder().checkRentedBike()) {
			Stage stage;
			Parent root;
			stage = (Stage) returnBikeButton.getScene().getWindow();
			root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/ReturnBikeScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Return Bike");
			stage.show();
		}
		else Popup.display("Error", "No Bike Was Rent");
	  }
	/**
	 * This method handle the changing to ViewDockScreen
	 * @throws IOException
	 */
	public void handleViewDockClick() throws IOException {
	    Stage stage;
	    Parent root;
	    stage = (Stage) viewDockButton.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/ViewDockScreen.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.setTitle("View Dock");
	    stage.show();
	  }
	
	/**
	 * This method handle changing to view current bike screen
	 */
	public void handleViewCurrentBikeClick() {
		if ( Order.getOrder().checkRentedBike()) {
			Stage stage;
			Parent root;
			stage = (Stage) viewCurrentBikeButton.getScene().getWindow();
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/fxml/ViewCurrentBikeScreen.fxml"));
				//
				//    		Stage stage;
				//    		stage = (Stage) bikeId.getScene().getWindow();
				stage.setScene(new Scene(loader.load()));
				ViewCurrentBikeScreenHandler controller = loader.getController();
				controller.init(Order.getOrder().getBike());
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else  Popup.display("Error", "No Bike Was Rent");
	}
}
