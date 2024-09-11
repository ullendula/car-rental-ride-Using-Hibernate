package com.rentalrides.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.rentalrides.entity.Admin;
import com.rentalrides.entity.Booking;
import com.rentalrides.entity.Car;
import com.rentalrides.entity.CarMaintenance;
import com.rentalrides.entity.Insurance;
import com.rentalrides.entity.Login;
import com.rentalrides.entity.Payment;
import com.rentalrides.entity.Register;
import com.rentalrides.entity.User;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure("Hibernate.cfg.xml")
					.addAnnotatedClass(Login.class)
					.addAnnotatedClass(Register.class)
					.addAnnotatedClass(User.class)
					.addAnnotatedClass(Admin.class)
					.addAnnotatedClass(Booking.class)
					.addAnnotatedClass(Car.class)
					.addAnnotatedClass(CarMaintenance.class)
					.addAnnotatedClass(Payment.class)
					.addAnnotatedClass(Insurance.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession()
	{
	  return getSessionFactory().openSession();
	}
}
