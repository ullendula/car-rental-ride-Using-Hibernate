package com.rentalrides.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rentalrides.Dao.LoginDao;
import com.rentalrides.entity.Login;
import com.rentalrides.util.HibernateUtil;

public class LoginDaoImpl implements LoginDao{

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public void saveLogin(Login login) {
		
		Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(login);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
		
	}

	@Override
	public Login getLoginByEmail(String email) {
		try (Session session = sessionFactory.openSession()) {
            return session.get(Login.class, email);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	


	

}
