package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.entity.Bike;
import application.model.entity.Invoice;
import application.model.entity.Order;
import application.model.services.BikeService;
import application.model.services.BikeTypeService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
/**
 * @author tungnt
 * This class used to control the view current bike screen
 *
 */

public class ViewCurrentBikeScreenHandler implements Initializable{


	@FXML
	private Text battery;

	@FXML
	private Text type;
	
	@FXML
	private Text deposit;
	
	@FXML
	private Text payFactor;
	
	@FXML 
	private Text rentTime;
	
	@FXML
	private Text amount;
	
	@FXML
	private ImageView imageBike;
	

	/**
	 *This method initialize the screen
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * The method used to pass initial value for bike attributes
	 * @param bike
	 */
	public void init(Bike bike) {
		Invoice  invoice = new Invoice(Order.getOrder());
		File file = new File(bike.getImageURL());
        Image image = new Image(file.toURI().toString());
		imageBike.setImage(image);
		deposit.setText(Double.toString(bike.getDepositValue()) + " vnd");
		battery.setText(bike.getStringBatteryStatus());
		type.setText(bike.getTypeName());
		payFactor.setText(Double.toString(bike.getPayFactor()));
		rentTime.setText(invoice.getStringDuration());
		amount.setText(invoice.getStringCost());
		
	}


	/**
	 *This method handle the onClick event of back-button
	 *@throws IOException
	 */
	public void handleBackClick() throws IOException{
		Stage stage;
		stage = (Stage) type.getScene().getWindow();
		Parent root;
		root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/HomeScreen.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Home");
		stage.show();
	}
}