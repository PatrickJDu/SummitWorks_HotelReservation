package com.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;
import com.model.Hotel;
public class HotelDao {

	public boolean add(Hotel hotel) {
		Session ses = HibernateUtil.openSession();
		if(this.doesHotelExist(hotel)) {
			return false;
		}
		Transaction t = null;
		try {
			t = ses.getTransaction();
			t.begin();
			ses.persist(hotel);
			t.commit();
		}catch(Exception e) {
			if(t!=null) {
				t.rollback();
			}
			System.out.println("An exception occurred...");
		}finally {
			ses.close();
		}
		return true;
	}
	public boolean doesHotelExist(Hotel hotel) {
		Session ses = HibernateUtil.openSession();
		boolean res = false;
		Transaction t = null;
		try {
			t = ses.getTransaction();
			t.begin();
			Query q = ses.createQuery("from Hotel where id='"+hotel.getId()+"'");
			Hotel h = (Hotel) q.uniqueResult();
			t.commit();
			if(h!=null) {
				res = true;
			}
		}catch(Exception e) {
			if(t!=null) {
				t.rollback();
			}
			e.printStackTrace();
		}finally {
			ses.close();
		}
		return res;
	}
	public boolean delete(Hotel hotel) {
		Session ses = HibernateUtil.openSession();
		if(!this.doesHotelExist(hotel)) {
			return false;
		}
		Transaction t = null;
		try {
			t = ses.getTransaction();
			t.begin();
			Hotel h = (Hotel) ses.load(Hotel.class, hotel.getId());
			ses.delete(h);
			t.commit();
		}catch(Exception e) {
			if(t!=null) {
				t.rollback();
			}
			System.out.println("An exception occurred...");
		}finally {
			ses.close();
		}
		return true;
	}
	public Hotel getHotelById(int id) {
		Session ses = HibernateUtil.openSession();
		Transaction t = null;
		Hotel h = null;
		try {
			t = ses.beginTransaction();
			t.begin();
			Query q = ses.createQuery("from Hotel where id = '" +id + "'");
			h = (Hotel) q.uniqueResult();
			t.commit();
		}catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        } finally {
            ses.close();
        }
		return h;
	}
	@SuppressWarnings("unchecked")
	public List<Hotel> getListOfHotels(){
		List<Hotel> loh= new ArrayList<>();
		Session ses = HibernateUtil.openSession();
		Transaction t = null;
		try {
			t = ses.beginTransaction();
			t.begin();
			loh = ses.createQuery("from Hotel").list();
			t.commit();
		}catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        } finally {
            ses.close();
        }
		return loh;
	}
}
