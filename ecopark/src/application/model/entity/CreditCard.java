package application.model.entity;

public class CreditCard {
	
	private int cardId;
	private String cardNumber;
	private String cardHolder;
	private String bankName;
	private String expireDate;
	private String cvv;
	
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCcv(String cvv) {
		this.cvv = cvv;
	}
	public CreditCard() {
		
	}
	public CreditCard(int cardId, String cardNumber, String cardHolder,String bankName, String expireDate) {
		super();
		this.cardId = cardId;
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.bankName = bankName;
		this.expireDate = expireDate;
	}
	public CreditCard(int cardId, String cardNumber, String cardHolder, String bankName, String expireDate,
			String cvv) {
		super();
		this.cardId = cardId;
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.bankName = bankName;
		this.expireDate = expireDate;
		this.cvv = cvv;
	}
	public CreditCard(String bankName, String cardNumber, String cardHolder, String expireDate,
			String cvv) {
		super();
		this.cardId = 1;
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.bankName = bankName;
		this.expireDate = expireDate;
		this.cvv = cvv;
	}
}
