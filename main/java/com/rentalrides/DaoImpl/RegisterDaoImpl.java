package com.rentalrides.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rentalrides.Dao.RegisterDao;
import com.rentalrides.entity.Register;
import com.rentalrides.util.HibernateUtil;

public class RegisterDaoImpl implements RegisterDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void saveRegister(Register register) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(register);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Register getRegisterByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Register.class, email);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}