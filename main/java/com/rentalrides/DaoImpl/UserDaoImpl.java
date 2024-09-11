package com.rentalrides.DaoImpl;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;

import com.rentalrides.Dao.UserDao;
import com.rentalrides.entity.User;
import com.rentalrides.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User saveUser(User user) {

		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return user;
	}

	@Override
	public User getUserById(Long userId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, userId);
        }
	}

	@Override
	public User getUserByEmail(String email) {
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("FROM User WHERE email = :email", User.class)
	                          .setParameter("email", email)
	                          .uniqueResult();
	        }
	}

	@Override
	public List<User> getAllUsers() {
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from User", User.class).list();
	        }
	}

	@Override
	public void updateUser(User user) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.update(user);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }		
	}

	@Override
	public void deleteUser(Long userId) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user != null) {
                session.delete(user);
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

	

