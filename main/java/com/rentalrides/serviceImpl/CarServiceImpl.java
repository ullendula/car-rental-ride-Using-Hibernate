package com.rentalrides.serviceImpl;

import java.util.List;

import com.rentalrides.DaoImpl.CarDaoImpl;
import com.rentalrides.entity.Car;
import com.rentalrides.service.CarService;

public class CarServiceImpl implements CarService{

	private CarDaoImpl carDao = new CarDaoImpl();

    @Override
    public void saveCar(Car car) {
        carDao.saveCar(car);
    }

    @Override
    public Car getCarById(Long carId) {
        return carDao.getCarById(carId);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    @Override
    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

    @Override
    public void deleteCar(Long carId) {
        carDao.deleteCar(carId);
    }

	
}
