package com.rentalrides.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rentalrides.Dao.CarMaintenanceDao;
import com.rentalrides.entity.CarMaintenance;
import com.rentalrides.util.HibernateUtil;

public class CarMaintenanceDaoImpl implements CarMaintenanceDao {

	@Override
    public void saveCarMaintenance(CarMaintenance carMaintenance) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(carMaintenance);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public CarMaintenance getCarMaintenanceById(Long carMaintenanceId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(CarMaintenance.class, carMaintenanceId);
        }
    }

    @Override
    public List<CarMaintenance> getAllCarMaintenances() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from CarMaintenance", CarMaintenance.class).list();
        }
    }

    @Override
    public void updateCarMaintenance(CarMaintenance carMaintenance) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(carMaintenance);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCarMaintenance(Long carMaintenanceId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CarMaintenance carMaintenance = session.get(CarMaintenance.class, carMaintenanceId);
            if (carMaintenance != null) {
                session.delete(carMaintenance);
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
