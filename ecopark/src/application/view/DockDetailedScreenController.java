package application.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.controller.DockDetailedController;
import application.model.entity.Bike;
import application.model.entity.Dock;
import application.model.services.BikeService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DockDetailedScreenController {
	@FXML
	private VBox dockInfoDisplay;
	@FXML
	private GridPane bikeListDisplay;
	@FXML
	private Button backBtn;
	@FXML
	private ScrollPane scrollWrap;
	private int dockId;
	private DockDetailedController controller;
	private BikeService bikeHandler = new BikeService();

//	public DockDetailedScreenController(int dockId) {
//		this.controller = new DockDetailedController();
//		this.dockId = dockId;
//	}

	public void init(int dockId) {
		this.controller = new DockDetailedController();
		this.bikeHandler = new BikeService();
		this.dockId = dockId;
		displayDockInfo();
		List<Bike> testList = bikeHandler.getBikeList(dockId);
		System.out.println("Bike List size " + testList.get(3).getStringBatteryStatus());
		displayBikeList(testList);
	}

	@FXML
	public void initialize() throws IOException {

	}

	public void displayDockInfo() {
		Dock dock = controller.getDockInfo(this.dockId);
		Text dockInfo = new Text();
		dockInfo.setFont(new Font(30));
		dockInfo.setText(dock.toString());

		dockInfoDisplay.getChildren().add(dockInfo);
	}

	public void displayBikeList(List<Bike> listBikes) {
		RowConstraints rowConstraint = new RowConstraints();
		rowConstraint.setMinHeight(30);
		rowConstraint.setPrefHeight(30);

		int row_count = 0;
		final int MAX_ROW_COUNT = 3;
		for (int i = 1; i <= listBikes.size(); i++) {
			row_count++;
			if (row_count >= MAX_ROW_COUNT) {
				bikeListDisplay.getRowConstraints().add(rowConstraint);
			}
			String bikeId = listBikes.get(i - 1).getId();
			Text bikeType = new Text();
			bikeType.setFont(new Font(15));
			bikeType.setText(listBikes.get(i - 1).getTypeName());
			GridPane.setConstraints(bikeType, 0, i);
			GridPane.setHalignment(bikeType, HPos.CENTER);
			Text bikeBattery = new Text();
			bikeBattery.setFont(new Font(15));
			bikeBattery.setText(listBikes.get(i - 1).getStringBatteryStatus());
			GridPane.setConstraints(bikeBattery, 1, i);
			GridPane.setHalignment(bikeBattery, HPos.CENTER);

			Button detailBikeBtn = new Button("Detail");
		    detailBikeBtn.setStyle("-fx-background-color: linear-gradient(SPRINGGREEN, SNOW);");
		    detailBikeBtn.setPadding(new Insets(2, 5, 2, 5));
		    detailBikeBtn.setFont(new Font(15));
			GridPane.setConstraints(detailBikeBtn, 2, i);
			GridPane.setHalignment(detailBikeBtn, HPos.CENTER);
			detailBikeBtn.setOnAction(actionEvent -> {
				Stage stage;
				Parent root;
				stage = (Stage) detailBikeBtn.getScene().getWindow();
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/fxml/ViewBikeScreen.fxml"));
					//
					//    		Stage stage;
					//    		stage = (Stage) bikeId.getScene().getWindow();
					stage.setScene(new Scene(loader.load())
							);

					ViewBikeScreenHandler controller = loader.getController();
					controller.init(bikeId, this.dockId);

					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			bikeListDisplay.getChildren().addAll(bikeType, bikeBattery, detailBikeBtn);
			//      bikeListDisplay.getChildren().addAll(bikeId, bikeBattery);
		}
		scrollWrap.setFitToHeight(true);
		scrollWrap.setFitToWidth(true);
	}

	public void handleBackButtonClicked() throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) backBtn.getScene().getWindow();
		root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/ViewDockScreen.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("View Dock");
		stage.show();
		
		
	}
}
