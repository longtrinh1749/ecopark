package application.model.services;

import application.model.dao.TransactionDAO;
import application.model.dao.impl.TransactionDAOImpl;
import application.model.entity.Transaction;

public class TransactionService implements TransactionServiceInterface{
	TransactionDAO transactionDAO;
	
	public TransactionService() {
		this.transactionDAO = new TransactionDAOImpl(); 
	}
	
	public boolean saveTransaction(Transaction transaction) {
		int rs = transactionDAO.saveTransaction(transaction.getAmount(), transaction.getCard());
		return rs == 1 ? true : false;
	}
}
