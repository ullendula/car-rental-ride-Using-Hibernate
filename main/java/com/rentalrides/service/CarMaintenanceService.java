package com.rentalrides.service;

import java.util.List;

import com.rentalrides.entity.CarMaintenance;

public interface CarMaintenanceService {

	 void saveCarMaintenance(CarMaintenance carMaintenance);
	    CarMaintenance getCarMaintenanceById(Long carMaintenanceId);
	    List<CarMaintenance> getAllCarMaintenances();
	     void updateCarMaintenance(CarMaintenance carMaintenance);
	    void deleteCarMaintenance(Long carMaintenanceId);
	
}
