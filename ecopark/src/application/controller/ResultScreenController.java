package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * This class is used to display the result of the rent bike proccess
 * @author tungnt
 * @version 1.0
 *
 */
public class ResultScreenController {
	@FXML
	private Label resultLabel;

	@FXML
	private Button okButton;
	
	@FXML
	private Label messageLabel;
	ResultController controller;
	public ResultScreenController() {
		this.controller = new ResultController();
	}
	@FXML
	public void initialize() throws IOException {
		resultLabel.setText(controller.getResult());
		messageLabel.setText(controller.getMessage());
	}
	  
	public void handleOkClick() throws IOException {
		//change to home screen
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
