package application.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.controller.ViewDockController;
import application.model.entity.Dock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewDockScreenController {
	@FXML
	private Button searchDockButton;
	@FXML
	private Button homeScreenButton;
	@FXML
	private Button cancelSearchButton;
	@FXML
	private TextField dockAddressField;
	@FXML
	private GridPane dockListDisplay;
	@FXML
	private ScrollPane scrollWrap;
	private ViewDockController controller;
	private boolean searching;

	public ViewDockScreenController() {
		this.searching = false;
		this.controller = new ViewDockController();
	}

	@FXML
	public void initialize() throws IOException {
		displayListDocks(controller.getAllDock());
	}

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
			Text noOfBike = new Text();
			noOfBike.setFont(new Font(20));
			noOfBike.setText(Integer.toString(listDocks.get(i - 1).getBikeNum()));
			GridPane.setConstraints(noOfBike, 2, i);
			GridPane.setHalignment(noOfBike, HPos.CENTER);

			Button detailDockBtn = new Button("Detail");
		    detailDockBtn.setStyle("-fx-background-color: linear-gradient(SPRINGGREEN, SNOW);");
		    detailDockBtn.setPadding(new Insets(2, 5, 2, 5));
		    detailDockBtn.setFont(new Font(15));
			GridPane.setConstraints(detailDockBtn, 3, i);
			GridPane.setHalignment(detailDockBtn, HPos.CENTER);
			int tmpDockId = listDocks.get(i - 1).getId();
			detailDockBtn.setOnAction(actionEvent -> {
				Stage stage;
				Parent root;
				FXMLLoader loader;
				stage = (Stage) detailDockBtn.getScene().getWindow();
				try {
					//          loader = new FXMLLoader();
					//          loader.setLocation(getClass().getClassLoader().getResource("application/view/fxml/DockDetailedInfoScreen.fxml"));
					//          loader.setController(new DockDetailedScreenController(tmpDockId));
					//          root = loader.load();
					//          Scene scene = new Scene(root);
					//          stage.setScene(scene);
					//          stage.setTitle("Detail information");
					//          stage.show();

					loader = new FXMLLoader(getClass().getResource("/application/view/fxml/DockDetailedInfoScreen.fxml"));
					stage.setScene(new Scene(loader.load())
							);

					DockDetailedScreenController controller = loader.getController();
					controller.init(tmpDockId);

					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			dockListDisplay.getChildren().addAll(dockId, dockAddr, noOfBike, detailDockBtn);
		}
		scrollWrap.setFitToHeight(true);
		scrollWrap.setFitToWidth(true);
	}

	public void handleSearchClicked() throws IOException {
		List<Node> retainNodes = new ArrayList<Node>();
		for (int i = 0; i < 5; i++) {
			Node node = dockListDisplay.getChildren().get(i);
			retainNodes.add(node);
		}
		dockListDisplay.getChildren().clear();
		for (int i = 0; i < 5; i++) {
			dockListDisplay.getChildren().add(i, retainNodes.get(i));
		}
		this.searching = true;
		try {
			String query = dockAddressField.getText();
			List<Dock> matched = controller.searchDock(query);
			displayListDocks(matched);
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
	}

	public void handleCancelDockClicked() throws IOException {
		if (this.searching) {
			List<Node> retainNodes = new ArrayList<Node>();
			for (int i = 0; i < 5; i++) {
				Node node = dockListDisplay.getChildren().get(i);
				retainNodes.add(node);
			}
			dockListDisplay.getChildren().clear();
			for (int i = 0; i < 5; i++) {
				dockListDisplay.getChildren().add(i, retainNodes.get(i));
			}
			displayListDocks(controller.getAllDock());
			this.searching = false;
		}
	}
	
	public void handleHomeScreenClicked() throws IOException {
	  Stage stage;
    Parent root;
    stage = (Stage) homeScreenButton.getScene().getWindow();
    root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/HomeScreen.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("EcoBikeRental");
    stage.show();
	}
}