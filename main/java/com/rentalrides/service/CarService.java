package com.rentalrides.service;

import java.util.List;

import com.rentalrides.entity.Car;

public interface CarService {
	
	 void saveCar(Car car);
	    Car getCarById(Long carId);
	    List<Car> getAllCars();
	    void updateCar(Car car);
	    void deleteCar(Long carId);

}
