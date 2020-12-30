package application.model.services;

import application.model.dao.TransactionDAO;
import application.model.entity.Transaction;

public class TransactionService {
	TransactionDAO transactionDAO;
	
	public TransactionService(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO; 
	}
	
	public boolean saveTransaction(Transaction transaction) {
		int rs = transactionDAO.saveTransaction(transaction.getAmount(), transaction.getCard());
		return rs == 1 ? true : false;
	}
}
