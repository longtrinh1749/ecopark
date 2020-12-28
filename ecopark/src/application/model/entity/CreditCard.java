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
	public boolean validateCard() {
		if ( validateCardNumber(cardNumber) && validateCardHolder(cardHolder) && validateExpiredDate(expireDate) &&
		validateBank(bankName)) return true;
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
}
