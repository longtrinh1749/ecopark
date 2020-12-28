package application.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import application.common.exception.InvalidCardException;
import application.model.entity.CreditCard;
import application.model.entity.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import application.controller.*;
/**
 * This class is used to control the payment screen
 * @author tungnt
 * @version 1.0
 */
public class PaymentScreenController{
	@FXML
	Button confirmPayment;
	@FXML
	private TextField cardNumber;
	@FXML	
	private TextField cardHolderName;
	@FXML
	private TextField experationDate;
	@FXML
	private TextField bank;
	@FXML
	private TextField securityCode;
	@FXML 
	private RadioButton creditCard;
	/**
	 * This function is used to init the payment info correct to api request
	 * @throws IOException
	 */
	@FXML
	public void initialize() throws IOException {
		creditCard.setSelected(true);
		bank.setText("viettinbank");
		cardNumber.setText("121319_group4_2020");
		cardHolderName.setText("Group 4");
		experationDate.setText("1125");
		securityCode.setText("517");
	}
	private static String result;
	private static String message;
	public String getResult() {
		return PaymentScreenController.result;
	}
	public String getMessage() {
		return PaymentScreenController.message;
	}
	
	/**
	 * This function is used to call the rentBike function and change to result screen 
	 * @throws IOException
	 * @throws ParseException
	 * @throws SQLException
	 */
	public void handleConfirmPaymentClick() throws IOException, ParseException, SQLException {
	RentBikeController rentBikeController = new RentBikeController();
	CreditCard card = new CreditCard(bank.getText(), cardNumber.getText(), cardHolderName.getText(), experationDate.getText(), securityCode.getText());
	rentBikeController.setCard(card);
	try {
		rentBikeController.rentBike();
		
		//passing the payment result value and change to result screen
		result = rentBikeController.getTransactionResult();
		message = rentBikeController.getTransactionMessage();
	    Stage stage;
	    Parent root;
	    stage = (Stage) confirmPayment.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxml/ResultScreen.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.setTitle("Result");
	    stage.show();
	} catch (InvalidCardException e) {
		Popup.display("Error", "Invalid Card");
			}
	}
}
