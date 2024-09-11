package com.rentalrides.DaoImpl;

import java.util.List;

import org.hibernate.Session;

import com.rentalrides.Dao.AdminDao;
import com.rentalrides.entity.Admin;
import com.rentalrides.util.HibernateUtil;


public class AdminDaoImpl implements AdminDao {

	 @Override
	    public void saveAdmin(Admin admin) {
	        org.hibernate.Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(admin);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Admin getAdminById(Long adminId) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.get(Admin.class, adminId);
	        }
	    }

	    @Override
	    public Admin getAdminByEmail(String email) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("FROM Admin WHERE email = :email", Admin.class)
	                          .setParameter("email", email)
	                          .uniqueResult();
	        }
	    }

	    @Override
	    public List<Admin> getAllAdmins() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Admin", Admin.class).list();
	        }
	    }

	    @Override
	    public void updateAdmin(Admin admin) {
	        org.hibernate.Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.update(admin);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteAdmin(Long adminId) {
	        org.hibernate.Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            Admin admin = session.get(Admin.class, adminId);
	            if (admin != null) {
	                session.delete(admin);
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
