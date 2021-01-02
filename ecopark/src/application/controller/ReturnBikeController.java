package application.controller;

import application.model.services.BikeService;
import application.model.services.BikeServiceInterface;
import application.model.services.DockService;
import application.model.services.DockServiceInterface;
import application.model.services.OrderService;
import application.model.services.OrderServiceInterface;
import application.model.services.PaymentService;
import application.model.services.PaymentServiceInterface;
import application.model.services.TransactionService;
import application.model.services.TransactionServiceInterface;
import application.subsystems.interbank.InterbankBoundary;
import application.subsystems.interbank.InterbankRequest;
import application.subsystems.interbank.InterbankService;

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
	
	  private DockServiceInterface dockService;
	  private static Invoice invoice;
	  private  Order order;
	  private Transaction refundTransaction;
	  private Transaction payRentTransaction;
	  private InterbankRequest refundRequest;
	  private InterbankRequest payRentRequest;
	  private InterbankService interbankService;
	  private BikeServiceInterface bikeservice;
	  private TransactionServiceInterface transactionService;
	  private PaymentServiceInterface paymentService;
	  private OrderServiceInterface orderService;
	  public Transaction getPaymentTransaction() {
		  return payRentTransaction;
	  }
	  
	  public ReturnBikeController() {
	    dockService = new DockService();
	    bikeservice = new BikeService();
	    orderService = new OrderService();
	    order = Order.getOrder();
	    transactionService = new TransactionService();
	    paymentService = new PaymentService();
	   }
	  
	  /**
	   * this method get the dock list for the return bike screen
	   * @return List
	   */
	  
	  public List<Dock> getAvailableDockForReturnBike() {
	    return dockService.getAvailableDockForReturnBike();
	  }
	  
	  /**
	   * This method get the number of empty parking lot of the dock 
	   * @param dockId
	   * @return number of empty lots
	   */
	  public int getNumberOfSlot(int dockId) {
		  return dockService.getEmptyParkingLot(dockId);
	  }
	  
	  
	  public Invoice getInvoice() {
		  return ReturnBikeController.invoice;
	  }
	  void setDockId(int dockId) {
		  order = Order.getOrder();
		  order.getBike().setDockId(dockId);
	  }
	  /**
	   * This function is used to refund the deposit value 
	   */
	  void returnDeposit() {
		  // return deposit 
		  double depositAmount = order.getBike().getDepositValue();
		  refundTransaction = new Transaction(depositAmount, order.getCard(), "refund","moneyyy");
		  refundRequest = new InterbankRequest(AppConfig.TRANSACTION_URL, refundTransaction);
		  interbankService = new InterbankService(new InterbankBoundary());
		  interbankService.refund(refundRequest);
		  transactionService.saveTransaction(refundTransaction);
	  }
	  
	  /**
	   * This function is used to pay the rental fee
	   */
	  void payRent() {
		  // paying rent money 
		  double rentAmount = paymentService.calculateCost(order);
		  payRentTransaction = new Transaction(rentAmount, order.getCard(), "pay","moneyyy");
		  payRentRequest = new InterbankRequest(AppConfig.TRANSACTION_URL, payRentTransaction);
		  interbankService = new InterbankService(new InterbankBoundary());
		  interbankService.pay(payRentRequest);
	  }
	  
	  /**
	   * This function is used to update the dock id for the bike when it being returned
	   * @param dockId
	   */
	  void updateDockId(int dockId) {
		  bikeservice.updateDockIdByReturnBike(order.getBike().getId(), dockId);
	  }
	  /**
	   * This function is used to return the bike with to the Dock with dockId param
	   * @param dockId
	   */
	  public void returnBike(int dockId) {
		  returnDeposit();
		  payRent();
		  if (payRentTransaction.getTransactionResult() == "Successful Payment" ) { 
			  updateDockId(dockId);	
			  transactionService.saveTransaction(payRentTransaction);
			  invoice = new  Invoice (order.getBike(), order.getCard(), order.getRentStartTime(), paymentService.calculateCost(order));
			  order.clearOrder(); 
		  } 
	  }
	  
}
