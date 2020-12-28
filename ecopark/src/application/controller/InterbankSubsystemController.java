package application.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import application.model.entity.CreditCard;
import application.model.entity.Transaction;
import application.model.subsystems.interbank.InterbankRequest;
import application.model.subsystems.interbank.InterbankService;
import application.utils.Utils;

public class InterbankSubsystemController {

	private static final String SECRET_KEY = "BWsYjXlloHg=";
	private static final String URL_PROCESS_TRANSACTION = "https://ecopark-system-api.herokuapp.com/api/card/processTransaction";
	public static DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	private InterbankService interbankService;
	
	public InterbankSubsystemController(InterbankService interbankService) {
		super();
		this.interbankService = interbankService;
	}

	public boolean pay(CreditCard card, int amount, String transactionContent) {
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setCard(card);
		transaction.setTransactionContent(transactionContent);
		transaction.setCommand("pay");
		transaction.setCreatedAt(Utils.getToday());
		InterbankRequest request = new InterbankRequest(URL_PROCESS_TRANSACTION, transaction);
		interbankService.pay(request);
		return true;
	}
	
	public boolean refund(CreditCard card, int amount) {
		InterbankRequest request = new InterbankRequest(null, null);
		// TODO
		interbankService.refund(request);
		return true;
	}
}
