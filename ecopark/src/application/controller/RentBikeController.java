package application.controller;

import application.model.entity.Bike;
import application.model.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


import application.model.entity.CreditCard;
import application.model.entity.Transaction;
import application.model.services.BikeService;
import application.model.subsystems.interbank.InterbankBoundary;
import application.model.subsystems.interbank.InterbankRequest;
import application.model.subsystems.interbank.InterbankService;
import application.AppConfig;
import application.common.exception.InvalidCardException;
import application.model.entity.Order;
import application.model.entity.CreditCard;
/**
 * This class controls the flow of rent bike usecase in our EcoBikeRental project
 * @author tungnt
 * @version 1.0
 */
public class RentBikeController{
	private static Bike bike;
	private static CreditCard card;
	private static String transactionResult;
	private static String transactionMessage;
	
	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		RentBikeController.bike = bike;
	}
	public void setCard(CreditCard card) {
		RentBikeController.card = card;
	}
	public String getTransactionResult() {
		return RentBikeController.transactionResult;
	}
	public String getTransactionMessage() {
		return RentBikeController.transactionMessage;
	}
	/**
	 * This method is used to create an order when user rent bike
	 * @param rent_start
	 * @param bikeId
	 */
	void createOrder() {
		Order order = Order.getOrder();
		order.setBike(bike);
		order.setCard(card);
		order.setRentStartTime();
	}
	
	/**
	 * this method is used to validate the payment method
	 * @param 
	 * @throws ParseException 
	 */
	boolean validatePaymentMethod() {
		return card.validateCard();
	}

	/**
	 * This method is used to process the transaction
	 * @param card
	 * @return transaction result
 	 * @throws ParseException
	 */
	void processTransaction(CreditCard card) {
		double amount = bike.getDepositValue();
		Transaction transaction = new Transaction(amount, card, "pay","moneyyy");
		InterbankRequest request = new InterbankRequest(AppConfig.TRANSACTION_URL, transaction);
		InterbankService interbankService = new InterbankService(new InterbankBoundary());
		interbankService.pay(request);
		RentBikeController.transactionMessage = transaction.getTrasactionMessage();
		RentBikeController.transactionResult = transaction.getTransactionResult();
	}
	/**
	 * this method is used to save the transaction to DB
	 * @param 
	 */
	void saveTransaction(CreditCard card) {
		//TODO
	}
	/**
	 * This method is used to clear the bike of the RentBikeController
	 */
	void clearRentBike() {
		RentBikeController.bike = new Bike();
	}
	/**
	 * This method is used to rent bike
	 * @param card
	 * @throws ParseException InvalidCardException
	 */	
	void rentBike() throws InvalidCardException, SQLException {
		createOrder();
		boolean validatePaymentResult = validatePaymentMethod();
		if (validatePaymentResult) {
			processTransaction(card);
			if (transactionResult == "Successful Payment" ) { 
				saveTransaction(card);
				BikeService bikeservice = new BikeService();
				bikeservice.updateDockIdByRentBike(bike.getId());
			} else Order.getOrder().clearOrder();
		}
		else {
			Order.getOrder().clearOrder();
			throw new InvalidCardException();
		}
	}
}
