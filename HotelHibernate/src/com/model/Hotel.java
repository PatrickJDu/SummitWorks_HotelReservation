package com.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private int id;
	private String hname;
	private String location;
	private List <Room> rooms;
	private int occupiedCnt;
	private int numOfRoom;
	private static final int NOT_FOUND = -1;
	public Hotel() {
		super();
		this.rooms = new ArrayList<>();
		this.setHname("");
		this.location = "";
		this.occupiedCnt = 0;
	}
	
	public Hotel(String name, String location) {
		super();
		this.setHname(name);
		this.location = location;
		this.occupiedCnt = 0;
		this.rooms = new ArrayList<>();
		this.numOfRoom = 0;
	}


	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public int getOccupiedCnt() {
		return occupiedCnt;
	}
	public void setOccupiedCnt(int occupiedCnt) {
		this.occupiedCnt = occupiedCnt;
	}
	
	public int getNumOfRoom() {
		return numOfRoom;
	}

	public void setNumOfRoom(int numOfRoom) {
		this.numOfRoom = numOfRoom;
	}

	public void addRoom(int roomNumber, String bedType, char smoking, double rate) {
		Room room = new Room(roomNumber, bedType, smoking, rate);
		room.setName("Not Occupied");
		this.rooms.add(room);
		room.setOccupied(false);
		this.numOfRoom++;
	}
	public boolean isFull() {
		int counter = 0;
		for(Room room: this.rooms) {
			if(!room.isOccupied()) {
				counter++;
			}
			else {
				break;
			}
		}
		return counter==this.numOfRoom?false:true;
	}
	public boolean isEmpty() {
		int counter = 0;
		for(Room room: this.rooms) {
			if(!room.isOccupied()) {
				counter++;
			}
			else {
				break;
			}
		}
		return counter==this.numOfRoom?true:false;
	}
	public void addReservation(String name, char smoking, String bedType) {
		boolean reserved = false;
		for(Room room: rooms) {
			if(room.getSmoking() == smoking && room.getBedType() == bedType) {
				room.setName(name);
				room.setOccupied(true);
				System.out.println("Reservation has been made!");
				reserved = true;
				this.occupiedCnt++;
				break;
			}
		}
		if(reserved == false) {
			System.out.println("A reservation could not be made.");
		}
	}
	public void cancelReservation(String name) {
		int index = this.findReservation(name);
		if(index == -1) {
			System.out.println("No reservation found");
		}
		else {
			Room room = this.rooms.get(index);
			room.setOccupied(false);
			this.occupiedCnt--;
			room.setName("Not Occupied");
			System.out.println("Reservation cancelled successfully!");
		}
	}
	private int findReservation(String name) {
		int index = 0;
		for(Room room: this.rooms) {
			if(room.getName().compareTo(name) == 0) {
				return index;
			}
			else {
				index++;
			}
		}
		return Hotel.NOT_FOUND;
	}
	public void printReservationList() {
		for(Room room:this.rooms) {
			System.out.println("Room Number: " + room.getRoomNumber());
			System.out.println("Occupant name: " + room.getName());
			System.out.println("Smoking room: " + room.getSmoking());
			System.out.println("Bed Type: " + room.getBedType());
			System.out.println("Rate: " + room.getRate());
		}
	}
	public double getDailySales() {
		double totalRate = 0.0;
		for(Room room: this.rooms) {
			totalRate = room.getRate();
		}
		return totalRate;
	}
	public double occupancyPercentage() {
		return (this.occupiedCnt/this.numOfRoom)*100;
	}

	@Override
	public String toString() {
		return "Hotel Name: " + this.getHname() + "\n" +
		"Number of Rooms: " + this.numOfRoom + "\n" + 
		"Number of Occupied rooms: " + this.getOccupiedCnt() + "\n"
		+"Room Details are: " + "\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}
	
}
