package application.view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.controller.ViewBikeController;
import application.model.entity.Bike;
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

/**
 * @author anhtnguyen
 * This class used to control the view bike screen
 *
 */

public class ViewBikeScreenHandler implements Initializable{

	@FXML
	private Text battery;

	@FXML
	private Text type;
	
	@FXML
	private Text id;
	
	@FXML
	private Text deposit;
	
	@FXML
	private Text payFactor;
	
	@FXML
	private ImageView imageBike;
	
	private String bikeId;
	
	private int dockId;
	
	private ViewBikeController controller;
	
	/**
	 *This method initialize the screen
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	}
	/**
	 * The method used to pass initial value for bike attributes
	 * @param bikeId
	 * @param dockId
	 */
	public void init(String bikeId, int dockId) {
		this.bikeId = bikeId;
		this.dockId = dockId;
		this.controller = new ViewBikeController();
		Bike b = controller.getBikeInfo(bikeId);
		File file = new File(b.getImageURL());
        Image image = new Image(file.toURI().toString());
		imageBike.setImage(image);
		id.setText(bikeId);
		deposit.setText(Double.toString(b.getDepositValue()) + " vnd");
		battery.setText(b.getStringBatteryStatus());
		type.setText(b.getTypeName());
		payFactor.setText(Double.toString(b.getPayFactor()));
		
	}


	/**
	 *This method handle the onClick event of back-button
	 *@throws IOException
	 */
	public void handleBackClick() throws IOException{
		
		Stage stage = (Stage) type.getScene().getWindow();;
		Parent root;
		FXMLLoader loader;
		loader = new FXMLLoader(getClass().getResource("/application/view/fxml/DockDetailedInfoScreen.fxml"));
		stage.setScene(new Scene(loader.load())
				);

		DockDetailedScreenController controller = loader.getController();
		controller.init(dockId);

		stage.show();
	}
}