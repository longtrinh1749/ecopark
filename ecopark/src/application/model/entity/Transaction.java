package application.model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	private CreditCard card;
	private String command;
	private String transactionContent;
	private double amount;
	private String createdAt;
	private String interbankTransactionId;
	private String errorCode;
	public CreditCard getCard() {
		return card;
	}
	public void setCard(CreditCard card) {
		this.card = card;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getTransactionContent() {
		return transactionContent;
	}
	public void setTransactionContent(String transactionContent) {
		this.transactionContent = transactionContent;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getInterbankTransactionId() {
		return interbankTransactionId;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getTrasactionMessage() {
		switch ( this.errorCode ) {
		case "00": 
			return "Have a nice ride!";
		case "01":
			return "Invalid Card";
		case "02":
			return "Not Enough Balance";
		case "03":
			return "Internal Sever Error";
		case "04":
			return "Supicious Transaction";
		case "05":
			return "Lacking Transaction Info";
		case "06":
			return "Lacking Version Info";
		case "07":
			return "Invalid Amount";
		default:
			return "Unknown Error";
		}
	}
	public String getTransactionResult() {
		if ( this.errorCode.equals("00") ) return "Successful Payment";
		else return "Payment Failed";
	}
	public void setInterbankTransactionId(String interbankTransactionId) {
		this.interbankTransactionId = interbankTransactionId;
	}
	public Transaction( double amount, CreditCard card, String command, String content) {
		super();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.amount = amount;
		Date timeStamp = new Date();
		this.createdAt = formatter.format(timeStamp);
		this.command = command;
		this.transactionContent = content;
		this.card = card;
	}
	public Transaction() {
		
	}
	public Transaction(CreditCard card, String command, String transactionContent, double amount, String createdAt,
			String interbankTransactionId) {
		super();
		this.card = card;
		this.command = command;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
		this.interbankTransactionId = interbankTransactionId;
	}
	public Transaction(CreditCard card, String command, String transactionContent, double amount,
			String interbankTransactionId) {
		super();
		SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		Date timeStamp = new Date();
		this.createdAt = formatter.format(timeStamp);
		this.card = card;
		this.command = command;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.interbankTransactionId = interbankTransactionId;
	}
}
