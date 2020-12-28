package application.view;

import java.io.IOException;

import application.controller.InvoiceController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * This class is used to control the invoice screen
 * @author tungnt
 * @version 1.0
 *
 */
public class InvoiceScreenController {
	@FXML 
	private Label bikeId;
	@FXML 
	private Label rentStartTime;
	@FXML 
	private Label rentFinishTime;
	@FXML 
	private Label duration;
	@FXML 
	private Label totalCost;
	@FXML 
	private Button okButton;
	InvoiceController controller;
	public InvoiceScreenController() {
		this.controller = new InvoiceController();
	}
	/**
	 * This function is used to initialize the invoice information
	 */
	@FXML 
	public void initialize(){
		this.bikeId.setText(controller.getBikeId());
		this.rentStartTime.setText(controller.getRentStartTime());
		this.rentFinishTime.setText(controller.getRentFinishTime());
		this.duration.setText(controller.getDuration());
		this.totalCost.setText(controller.getTotalCost());
	}
	/**
	 * This function is used to change to the home screen
	 * @throws IOException
	 */
	public void okButtonHandler() throws IOException {
	    Stage stage;
	    Parent root;
	    stage = (Stage) okButton.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/HomeScreen.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.setTitle("EcoBikeRental");
	    stage.show();
	}
}
