package application;
	
import java.io.IOException;
import java.sql.SQLException;

import application.view.HomeScreenController;
import application.model.dao.DockDAO;
import application.model.entity.CreditCard;
import application.model.entity.Transaction;
import application.model.services.BikeService;
import application.model.services.DockService;
import application.subsystems.interbank.InterbankBoundary;
import application.subsystems.interbank.InterbankRequest;
import application.subsystems.interbank.InterbankService;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
try {
			
			// initialize the scene
    		Parent root;
    		root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/SplashScreen.fxml"));
    		Scene scene = new Scene(root);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("EcoBikeRental");
    		primaryStage.show();
			// Load splash screen with fade in effect
			FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), root);
			fadeIn.setFromValue(0);
			fadeIn.setToValue(1);
			fadeIn.setCycleCount(1);

			// Finish splash with fade out effect
			FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), root);
			fadeOut.setFromValue(1);
			fadeOut.setToValue(0);
			fadeOut.setCycleCount(1);

			// After fade in, start fade out
			fadeIn.play();
			fadeIn.setOnFinished((e) -> {
				fadeOut.play();
			});

			// After fade out, load actual content
			fadeOut.setOnFinished((e) -> {
				//change to home screen
	    		try {
	    			Parent root1;
					root1 = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/HomeScreen.fxml"));
		    		Scene scene1 = new Scene(root1);
		    		primaryStage.setScene(scene1);
		    		primaryStage.setTitle("EcoBikeRental");
		    		primaryStage.show();
	    		} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	public static void main(String[] args) {
		launch(args);
		}
	
}