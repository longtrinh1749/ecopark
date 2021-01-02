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
import application.model.services.BikeServiceInterface;
import application.model.services.OrderService;
import application.model.services.OrderServiceInterface;
import application.model.services.TransactionService;
import application.model.services.TransactionServiceInterface;
import application.subsystems.interbank.InterbankBoundary;
import application.subsystems.interbank.InterbankInterface;
import application.subsystems.interbank.InterbankRequest;
import application.subsystems.interbank.InterbankService;
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
	private Transaction transaction;
	private TransactionServiceInterface transactionService;
	private InterbankRequest request;
	private InterbankService interbankService;
	private BikeServiceInterface bikeservice;
	private Order order;
	private OrderServiceInterface orderService;
	
	public RentBikeController() {
		bikeservice = new BikeService();
		order = Order.getOrder();
		transactionService = new TransactionService();
		orderService = new OrderService();
	}
	
	public Bike getBike() {
		return bike;
	}
	
	public Transaction getTransaction() {
		return transaction;
	}
	
	public void setBike(Bike bike) {
		RentBikeController.bike = bike;
	}
	
	public void setCard(CreditCard card) {
		RentBikeController.card = card;
	}
	/**
	 * This method is used to create an order when user rent bike
	 * @param rent_start
	 * @param bikeId
	 */
	void setOrder() {
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
		if ( validateCardNumber(card.getCardNumber()) && validateCardHolder(card.getCardHolder()) && validateExpiredDate(card.getExpireDate()) &&
		validateBank(card.getBankName())) return true;
		else return false;
	}
	
	public boolean validateCardNumber(String cardNumber) {
		// check if card number null
		if (cardNumber.isEmpty() || cardNumber == "") return false;
		return true;
	}
	public boolean validateCardHolder(String cardHolder) {
		// check if card holder null
		if ( cardHolder.isEmpty()) return false;
		return true;
	}
	public boolean validateBank(String bankName) {
		//check if bank name null
		if ( bankName.isEmpty() ) return false;
		return true;
	}
	public boolean validateExpiredDate(String expireDate) {
		// check if expired date null
		if ( expireDate.isEmpty()) return false;
		
		//check if expired date have 4 characters
		if ( expireDate.length() != 4) return false;
		
		// check if expired date right format
		String stringMonth = expireDate.substring(0, 2);
		String stringYear = expireDate.substring(2, 4);
		int month = Integer.parseInt(stringMonth);
		int year = Integer.parseInt(stringYear);
		System.out.println(stringMonth);
		System.out.println(stringYear);
		if ( month < 1 || month > 12 || year < 20 )
			return false;
		return true;
	}
	/**
	 * This method is used to process the transaction
	 * @param card
	 * @return transaction result
 	 * @throws ParseException
	 */
	void processTransaction() {
		double amount = bike.getDepositValue();
		transaction = new Transaction(amount, card, "pay","moneyyy");
		request = new InterbankRequest(AppConfig.TRANSACTION_URL, transaction);
		interbankService = new InterbankService(new InterbankBoundary());
		interbankService.pay(request);
	}

	/**
	 * This method is used to rent bike
	 * @param card
	 * @throws ParseException InvalidCardException
	 */	
	public void rentBike() throws InvalidCardException, SQLException {
		boolean validatePaymentResult = validatePaymentMethod();
		if (validatePaymentResult) {
			processTransaction();
			if (transaction.getTransactionResult() == "Successful Payment" ) { 
				setOrder();
				orderService.saveOrder(order);
				transactionService.saveTransaction(transaction);
				bikeservice.updateDockIdByRentBike(bike.getId());
				bike = new Bike();
			} else Order.getOrder().clearOrder();
		}
		else {
			throw new InvalidCardException();
		}
	}
}
