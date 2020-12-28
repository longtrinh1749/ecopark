package application.model.subsystems.interbank;

import java.util.Map;

import application.model.entity.CreditCard;
import application.model.entity.Transaction;
import application.utils.MD5Hash;
import application.utils.MyMap;
import application.model.subsystems.interbank.InterbankInterface;

/***
 * The {@code InterbankService} class is used to communicate with the
 * InterbankBoundary to make transaction.
 * 
 * @author longt
 *
 */
public class InterbankService {
	private static final String VERSION = "1.0.1";
	private static final String APP_CODE = "350c/beKWw==";
	private static final String SECRET_KEY = "BWsYjXlloHg=";
	
	/**
	 * Represent the boundary of the subsystem
	 */
	
	InterbankInterface interbank;
	
	/**
	 * Initializes a newly created {@code InterbankService} object so that it
	 * represents an Interbank service.
	 */
	public InterbankService(InterbankInterface interbank) {
		super();
		this.interbank = interbank;
	}
	
	private String generateData(Map<String, Object> data) {
		return ((MyMap) data).toJSON();
	}
	/**
	 * Pay order, and then set the value transaction errorCode in argument
	 * 
	 * @param request     - the interbank request contains data used for rest request to interbank
	 * 
	 */
	public void pay(InterbankRequest request) {
		Transaction transaction = request.getTransaction();
		CreditCard card = transaction.getCard();
		Map<String, Object> transactionMap = new MyMap();

		transactionMap.put("cardCode", card.getCardNumber());
		transactionMap.put("owner", card.getCardHolder());
		transactionMap.put("cvvCode", card.getCvv());
		transactionMap.put("dateExpired", card.getExpireDate());
		transactionMap.put("command", "pay");
		transactionMap.put("transactionContent", transaction.getTransactionContent());
		transactionMap.put("amount", transaction.getAmount());
		transactionMap.put("createdAt", transaction.getCreatedAt());

		Map<String, Object> requestMap = new MyMap();
		requestMap.put("version", VERSION);
		requestMap.put("transaction", transactionMap);
		requestMap.put("appCode", APP_CODE);
		String hashString = "asd";
		requestMap.put("hashCode", MD5Hash.getMD5(hashString));

//		String responseText = interbank.processTransaction(Configs.PROCESS_TRANSACTION_URL, generateData(requestMap));
//		MyMap response = null;
//		try {
//			response = MyMap.toMyMap(responseText, 0);
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//			throw new UnrecognizedException();
//		}
		transaction.setErrorCode(interbank.processTransaction(request.getUrl(), generateData(requestMap)));
	}
	/**
	 * Refund, and then set the value transaction errorCode in argument
	 * 
	 * @param request     - the interbank request contains data used for rest request to interbank
	 * 
	 */
	public void refund(InterbankRequest request) {
		Transaction transaction = request.getTransaction();
		CreditCard card = transaction.getCard();
		Map<String, Object> transactionMap = new MyMap();

		transactionMap.put("cardCode", card.getCardNumber());
		transactionMap.put("owner", card.getCardHolder());
		transactionMap.put("cvvCode", card.getCvv());
		transactionMap.put("dateExpired", card.getExpireDate());
		transactionMap.put("command", "refund");
		transactionMap.put("transactionContent", transaction.getTransactionContent());
		transactionMap.put("amount", transaction.getAmount());
		transactionMap.put("createdAt", transaction.getCreatedAt());

		Map<String, Object> requestMap = new MyMap();
		requestMap.put("version", VERSION);
		requestMap.put("transaction", transactionMap);
		requestMap.put("appCode", APP_CODE);
		String hashString = "asd";
		requestMap.put("hashCode", MD5Hash.getMD5(hashString));
		
		interbank.processTransaction(request.getUrl(), generateData(requestMap));
	}
}
