package application.model.dao;

//this class doing CRUD to db
public class DAO {
	
	public static final String QUERY_SELECT_ALL = "Select * from dock ";
	public static final String QUERY_INSERT = "insert into ? (?) values(?,?,?)";
	public static final String QUERY_UPDATE_BY_ID = "update User set username = ?, password = ? where id = ?";
	public static final String QUERY_DELETE_BY_ID = "delete from User where id = ?";
}
