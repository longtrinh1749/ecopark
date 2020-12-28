package application.model.entity;

public class Account {
	
	private int id;
	private String userName;
	private String password;
	private int customerId;
	
	public Account(int id, String username, String password, int customerid) {
		super();
		this.customerId = customerid;
		this.id = id;
		this.userName = username;
		this.password = password;
	}
	
}
