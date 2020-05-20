package com.client;

import java.util.List;

import com.dao.HotelDao;
import com.model.*;
public class Client {
	public static void main(String[] args) throws Exception {
		Hotel h = new Hotel("Beach Marriot", "California");
		h.addRoom(101, "king", 'n', 120.0);
		h.addRoom(102, "queen", 's', 110.0);
		h.addRoom(103, "twin", 'n', 88.0);
		h.addRoom(104, "king", 's', 96.0);
		h.addRoom(105, "queen", 'n', 89.0);
		h.addReservation("Pinto", 's', "king");
		h.addReservation("Kelly", 's', "queen");
		HotelDao hd = new HotelDao();
		hd.add(h);
		Hotel h1 = new Hotel("My House", "NYC");
		h1.addRoom(1, "king", 'n', 120.0);
		h1.addRoom(2, "queen", 'n', 110.0);
		h1.addReservation("Patrick", 'n', "king");
		h1.addReservation("Tina", 'n', "queen");
		hd.add(h1);
		List <Hotel> loh = hd.getListOfHotels();
		for(Hotel hotel: loh) {
			System.out.println(hotel.getHname());
		}
		System.out.println(hd.delete(h));
	}
}
