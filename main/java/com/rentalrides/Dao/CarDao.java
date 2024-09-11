package com.rentalrides.Dao;

import java.util.List;

import com.rentalrides.entity.Car;

public interface CarDao {
	
	void saveCar(Car car);
    Car getCarById(Long carId);
    List<Car> getAllCars();
    void updateCar(Car car);
    void deleteCar(Long carId);

}
