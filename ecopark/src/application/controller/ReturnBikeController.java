package application.controller;

import application.model.services.BikeService;
import application.model.services.DockService;
import application.model.subsystems.interbank.InterbankBoundary;
import application.model.subsystems.interbank.InterbankRequest;
import application.model.subsystems.interbank.InterbankService;

import java.util.ArrayList;
import java.util.List;

import application.AppConfig;
import application.model.entity.*;
/**
 * This class controls the flow of return bike usecase in our EcoBikeRental project
 * @author tungnt
 * @version 0.1
 */
public class ReturnBikeController{
	  private DockService dockServiceHandler;
	  private static Invoice invoice;
		private static String transactionResult;
		private static String transactionMessage;
		
	  public ReturnBikeController() {
	    this.dockServiceHandler = new DockService();
	  }
	  public String getTransactionResult(){
		  return ReturnBikeController.transactionResult;
	  }
	 public String getTransactionMessage() {
		 return ReturnBikeController.transactionMessage;
	 }
	  /**
	   * this method get the dock list for the return bike screen
	   * @return List
	   */
	  
	  public List<Dock> getAvailableDockForReturnBike() {
	    return dockServiceHandler.getAvailableDockForReturnBike();
	  }
	  
	  /**
	   * This method get the number of empty parking lot of the dock 
	   * @param dockId
	   * @return number of empty lots
	   */
	  public int getNumberOfSlot(int dockId) {
		  return dockServiceHandler.getEmptyParkingLot(dockId);
	  }
	  
	  
	  public Invoice getInvoice() {
		  return ReturnBikeController.invoice;
	  }
	  void setDockId(int dockId) {
		  Order order = Order.getOrder();
		  order.getBike().setDockId(dockId);
	  }
	  /**
	   * This function is used to refund the deposit value 
	   */
	  void returnDeposit() {
		  // return deposit 
		  double depositAmount = invoice.getOrder().getBike().getDepositValue();
		  Transaction refundTransaction = new Transaction(depositAmount, invoice.getOrder().getCard(), "refund","moneyyy");
		  InterbankRequest refundRequest = new InterbankRequest(AppConfig.TRANSACTION_URL, refundTransaction);
		  InterbankService interbankService = new InterbankService(new InterbankBoundary());
		  interbankService.refund(refundRequest);
	  }
	  
	  /**
	   * This function is used to pay the rental fee
	   */
	  void payRent() {
		  // paying rent money 
		  double rentAmount = invoice.getTotal();
		  Transaction payRentTransaction = new Transaction(rentAmount, invoice.getOrder().getCard(), "pay","moneyyy");
		  InterbankRequest payRentRequest = new InterbankRequest(AppConfig.TRANSACTION_URL, payRentTransaction);
		  InterbankService interbankService = new InterbankService(new InterbankBoundary());
		  interbankService.pay(payRentRequest);
		  ReturnBikeController.transactionMessage = payRentTransaction.getTrasactionMessage();
		  ReturnBikeController.transactionResult = payRentTransaction.getTransactionResult();
	  }
	  
	  /**
	   * This function is used to update the dock id for the bike when it being returned
	   * @param dockId
	   */
	  void updateDockId(int dockId) {
		  BikeService bikeservice = new BikeService(); 				// set dock id of the returned bike to the dockId
		  bikeservice.updateDockIdByReturnBike(invoice.getOrder().getBike().getId(), dockId);
		  Order.getOrder().clearOrder(); 	// clear order
	  }
	  /**
	   * This function is used to return the bike with to the Dock with dockId param
	   * @param dockId
	   */
	  void returnBike(int dockId) {
		  invoice = new Invoice(Order.getOrder());
		  returnDeposit();
		  payRent();
		  if (transactionResult == "Successful Payment" ) { 
			  updateDockId(dockId);
			  Order.getOrder().clearOrder(); 
		  // TODO save transaction
		  // TODO save invoice
		  } 
	  }
	  
}
