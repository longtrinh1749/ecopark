package application.controller;

import application.model.entity.Invoice;
/**
 * This class is used to get infomation to initialize the invoice screen
 * @author tungnt
 * @version 1.0
 *
 */
public class InvoiceController {
	private static Invoice invoice;
	
	public InvoiceController() {
		ReturnBikeController returnBikeController = new ReturnBikeController();
		InvoiceController.invoice = returnBikeController.getInvoice();
	}
	public String getDuration() {
		return invoice.getStringDuration();
	}
	
	public String getTotalCost() {
		return invoice.getStringCost();
	}
	
	public String getBikeId() {
		return invoice.getBike().getId();
	}
	public String getRentStartTime() {
		return invoice.getStringRentStartTime();
	}
	public String getRentFinishTime() {
		return invoice.getStringEndTime();
	}
	
}
