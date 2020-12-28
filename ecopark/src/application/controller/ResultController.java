package application.controller;
/**
 * This function is used to get the infomation for the result screen
 * @author tungnt
 * @version 1.0
 *
 */
public class ResultController {
	private String result;
	private String message;
	public String getResult() {
		return this.result;
	}
	public String getMessage() {
		return this.message;
	}
	public ResultController() {
		PaymentScreenController paymentScreenController = new PaymentScreenController();
		result = paymentScreenController.getResult();
		message = paymentScreenController.getMessage();	
	}
}
