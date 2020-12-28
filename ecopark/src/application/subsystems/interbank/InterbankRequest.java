package application.model.subsystems.interbank;

import application.model.entity.Transaction;

public class InterbankRequest {
	private String url;
	private Transaction transaction;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public InterbankRequest() {
		super();
	}
	public InterbankRequest(String url, Transaction transaction) {
		super();
		this.url = url;
		this.transaction = transaction;
	}
}
