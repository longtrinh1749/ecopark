package application.view;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import application.controller.ReturnBikeController;
import application.model.entity.*;
/**
 * This class control the return bike screen
 * @author tungnt
 * @version 1.0
 */
public class ReturnBikeScreenController{
	@FXML
	private TextField dockAddressField;
	@FXML
	private GridPane dockListDisplay;
	@FXML
	private ScrollPane scrollWrap;
	private ReturnBikeController controller;
	
	public ReturnBikeScreenController() {
	    this.controller = new ReturnBikeController();
	  }
	/**
	 * This function is used to initialize the available dock list for return bike
	 * @throws IOException
	 */
	  @FXML
	  public void initialize() throws IOException {
	    displayListDocks(controller.getAvailableDockForReturnBike());
	  }
	  /**
	   * This function is used to display the dock list for return bike
	   * @param listDocks
	   * @throws IOException
	   */
	  public void displayListDocks(List<Dock> listDocks) throws IOException {
	    RowConstraints rowConstraint = new RowConstraints();
	    rowConstraint.setMinHeight(30);
	    rowConstraint.setPrefHeight(30);
	    
	    int row_count = 0;
	    final int MAX_ROW_COUNT = 10;
	    for (int i = 1; i <= listDocks.size(); i++) {
	      row_count++;
	      if (row_count >= MAX_ROW_COUNT) {
	        dockListDisplay.getRowConstraints().add(rowConstraint);
	      }
	      Text dockId = new Text();
	      dockId.setFont(new Font(20));
	      dockId.setText(Integer.toString(listDocks.get(i - 1).getId()));
	      GridPane.setConstraints(dockId, 0, i);
	      GridPane.setHalignment(dockId, HPos.CENTER);
	      Text dockAddr = new Text();
	      dockAddr.setFont(new Font(20));
	      dockAddr.setText(listDocks.get(i - 1).getAddress());
	      GridPane.setConstraints(dockAddr, 1, i);
	      GridPane.setHalignment(dockAddr, HPos.CENTER);
	      Text noOfSlot = new Text();
	      noOfSlot.setFont(new Font(20));
	      int tmpDockId = listDocks.get(i - 1).getId();
	      noOfSlot.setText(Integer.toString(controller.getNumberOfSlot(tmpDockId)));
	      GridPane.setConstraints(noOfSlot, 2, i);
	      GridPane.setHalignment(noOfSlot, HPos.CENTER);
	      
	      Button returnBikeBtn = new Button("Return Bike");
	      returnBikeBtn.setStyle("-fx-background-color: linear-gradient(SPRINGGREEN, SNOW);");
	      returnBikeBtn.setPadding(new Insets(2, 5, 2, 5));
	      returnBikeBtn.setFont(new Font(15));
	      GridPane.setConstraints(returnBikeBtn, 3, i);
	      GridPane.setHalignment(returnBikeBtn, HPos.CENTER);
	      returnBikeBtn.setOnAction(actionEvent -> {
	    	 controller.returnBike(tmpDockId);
	    	 if (controller.getTransactionResult() == "Successful Payment" ) { 
	    	// move to invoice screen
	    		 try {
	    			 Stage stage;
	    			 Parent root;
	    			 stage = (Stage) returnBikeBtn.getScene().getWindow();
	    			 root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/InvoiceScreen.fxml"));
	    			 Scene scene = new Scene(root);
	    			 stage.setScene(scene);
	    			 stage.setTitle("Invoice");
	    			 stage.show();
	    		 } catch (IOException e) {
	    			 // TODO Auto-generated catch block
	    			 e.printStackTrace();
	    		 }} else Popup.display("Error",controller.getTransactionMessage());
	      });
	      
	      dockListDisplay.getChildren().addAll(dockId, dockAddr, noOfSlot, returnBikeBtn);
	    }
	    scrollWrap.setFitToHeight(true);
	    scrollWrap.setFitToWidth(true);
	  }

}
