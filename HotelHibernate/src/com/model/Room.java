package com.model;

public class Room {
	private int id;
	private int roomNumber;
	private String bedType;
	private char smoking;
	private boolean occupied;
	private double rate;
	private String name;
	public Room() {
		super();
	}
	public Room(int roomNumber, String bedType, char smoking, double rate) {
		super();
		this.roomNumber = roomNumber;
		this.bedType = bedType;
		this.smoking = smoking;
		this.rate = rate;
		this.name = "Not Occupied";
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	public char getSmoking() {
		return smoking;
	}
	public void setSmoking(char smoking) {
		this.smoking = smoking;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Occupant name: " + this.getName() + "\n" +
		"Smoking room: " + this.getSmoking() + "\n" + 
		"Bed Type: " + this.getBedType() + "\n" + 
		"Rate: " + this.getRate() + "\n";
				
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
