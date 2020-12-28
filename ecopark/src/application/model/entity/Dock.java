package application.model.entity;

import java.util.List;

public class Dock {
	
	private int id; 
	private String name;
	private String address;
	private int bikeNum;
	private int area;
	
  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBikeNum() {
		return bikeNum;
	}
	public void setBikeNum(int bikeNum) {
		this.bikeNum = bikeNum;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	
	public Dock(int id, String address) {
		super();
		this.id = id;
		this.address = address;
	}
	public Dock(int id, String name, String address, int bikeNum, int area) {
    super();
    this.id = id;
    this.name = name;
    this.address = address;
    this.bikeNum = bikeNum;
    this.area = area;
  }
	
	@Override
  public String toString() {
    return "Dock ID: " + id + "\nDock name: " + name + "\nDock address: " 
            + address + "\nNumber of bikes in dock: " + bikeNum + "\nDock area: " + area;
  }
	public String abbreviated_info() {
	  return "DockID: " + id + "\nDock address: " + address + "\nNumber of available bikes: " + bikeNum;
	}
}
