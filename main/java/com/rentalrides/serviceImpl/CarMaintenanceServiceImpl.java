package com.rentalrides.serviceImpl;

import java.util.List;

import com.rentalrides.DaoImpl.CarMaintenanceDaoImpl;
import com.rentalrides.entity.CarMaintenance;

public class CarMaintenanceServiceImpl implements com.rentalrides.service.CarMaintenanceService {

	private CarMaintenanceDaoImpl carMaintenanceDao = new CarMaintenanceDaoImpl();

    @Override
    public void saveCarMaintenance(CarMaintenance carMaintenance) {
        carMaintenanceDao.saveCarMaintenance(carMaintenance);
    }

    @Override
    public CarMaintenance getCarMaintenanceById(Long carMaintenanceId) {
        return carMaintenanceDao.getCarMaintenanceById(carMaintenanceId);
    }

    @Override
    public List<CarMaintenance> getAllCarMaintenances() {
        return carMaintenanceDao.getAllCarMaintenances();
    }

    @Override
    public void updateCarMaintenance(CarMaintenance carMaintenance) {
        carMaintenanceDao.updateCarMaintenance(carMaintenance);
    }

    @Override
    public void deleteCarMaintenance(Long carMaintenanceId) {
        carMaintenanceDao.deleteCarMaintenance(carMaintenanceId);
    }

}
