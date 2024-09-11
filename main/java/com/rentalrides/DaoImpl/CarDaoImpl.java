package com.rentalrides.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rentalrides.Dao.CarDao;
import com.rentalrides.entity.Car;
import com.rentalrides.util.HibernateUtil;

public class CarDaoImpl implements CarDao{
	
	@Override
    public void saveCar(Car car) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Car getCarById(Long carId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Car.class, carId);
        }
    }

    @Override
    public List<Car> getAllCars() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Car", Car.class).list();
        }
    }

    @Override
    public void updateCar(Car car) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(car);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCar(Long carId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Car car = session.get(Car.class, carId);
            if (car != null) {
                session.delete(car);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

	

}
