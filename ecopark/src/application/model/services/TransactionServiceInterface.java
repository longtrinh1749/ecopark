package application.model.services;

import application.model.entity.Transaction;
public interface TransactionServiceInterface {
	public boolean saveTransaction(Transaction transaction);
}
