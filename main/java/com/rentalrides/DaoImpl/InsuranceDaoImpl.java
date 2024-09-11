package com.rentalrides.DaoImpl;
import org.hibernate.SessionFactory;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rentalrides.Dao.InsuranceDao;
import com.rentalrides.entity.Insurance;
import com.rentalrides.util.HibernateUtil;
public class InsuranceDaoImpl implements InsuranceDao {

	 @Override
	    public void saveInsurance(Insurance insurance) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSession()) {
	            transaction = session.beginTransaction();
	            session.save(insurance);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Insurance getInsuranceById(Long insuranceId) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.get(Insurance.class, insuranceId);
	        }
	    }

	    @Override
	    public List<Insurance> getAllInsurances() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Insurance", Insurance.class).list();
	        }
	    }

	    @Override
	    public void updateInsurance(Insurance insurance) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.update(insurance);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteInsurance(Long insuranceId) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            Insurance insurance = session.get(Insurance.class, insuranceId);
	            if (insurance != null) {
	                session.delete(insurance);
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
