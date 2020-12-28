package application.model.entity;

public class Bike {
	
	public static final double DEPOSIT_FACTOR = 0.4;
	
	private String id;
	private int dockId;
	private String typeName;
	private double depositValue;
	private double batteryStatus;
	private String imageURL;
	private int type;
	private double payFactor;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDockId() {
		return dockId;
	}
	public void setDockId(int dockId) {
		this.dockId = dockId;
	}
	public double getDepositValue() {
		return depositValue;
	}
	public void setValue(double depositValue) {
		this.depositValue = depositValue;
	}
	
	public double getBatteryStatus() {
		return batteryStatus;
	}
	public String getStringBatteryStatus() {
		String stringBattery = Double.toString(batteryStatus) + " %";
		if ( typeName.equals("Standard e-bike") ) return stringBattery;
		else return "na";
	}
	public void setBatteryStatus(double batteryStatus) {
		this.batteryStatus = batteryStatus;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public double getPayFactor() {
		return payFactor;
	}
	public void setPayFactor(double payFactor) {
		this.payFactor = payFactor;
	}
	public void setDepositValue(double depositValue) {
		this.depositValue = depositValue;
	}
	
	public Bike() {
		
	}
	//this one for bike list
	public Bike(String id, String typeName, double depositValue, String imageURL) {
		super();
		this.id = id;
		this.depositValue = depositValue;
		this.imageURL = imageURL;
	}
	public Bike(String id, double depositValue, double batteryStatus, String imageURL, int type) {
		super();
		this.id = id;
		this.depositValue = depositValue;
		this.batteryStatus = batteryStatus;
		this.imageURL = imageURL;
		this.type = type;
	}

	//this one for bike full info
	public Bike(String id, String typeName, double depositValue, double batteryStatus, String imageURL,
			double payFactor) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.depositValue = depositValue;
		this.batteryStatus = batteryStatus;
		this.imageURL = imageURL;
		this.payFactor = payFactor;
	}
	/**
	 * this method is used to set the dockId of the rented bike to be null 
	 * @param bikeId
	 */
}
