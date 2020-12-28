package application.view;


import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * This class is used to show the popup window
 * @author tungnt
 * @version 1.0
 *
 */
public class Popup {
	/**
	 * This method is used to show the popup window
	 * @param title
	 * @param message
	 */
	public static void display(String title, String message) {
		String  imagePath = "assets/error_icon.png";
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(314);
		window.setMinHeight(215);
		
		Label label = new Label();
		label.setText(message);
		label.setFont( Font.font("System", FontWeight.BOLD, 20));
		
		Stop[] stops = new Stop[] { 
		         new Stop(0, Color.DARKSLATEBLUE),  
		         new Stop(1, Color.DARKRED)
		      };  
		LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
		label.setTextFill(linearGradient);
		
		File file = new File(imagePath);
	    Image image = new Image(file.toURI().toString());
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(108);
		imageView.setFitWidth(108);
		AnchorPane.setLeftAnchor(imageView, 0.0);
		AnchorPane.setRightAnchor(imageView, 0.0);
		AnchorPane.setLeftAnchor(imageView, 90.0);
	
		AnchorPane layout = new AnchorPane(label,imageView);
		AnchorPane.setRightAnchor(label, 0.0);
		AnchorPane.setLeftAnchor(label, 0.0);
		AnchorPane.setTopAnchor(label, 120.0);
		label.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
