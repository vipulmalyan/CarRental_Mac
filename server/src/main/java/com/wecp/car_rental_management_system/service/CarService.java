package com.wecp.car_rental_management_system.service;

import com.wecp.car_rental_management_system.entity.Car;
import com.wecp.car_rental_management_system.entity.CarCategory;
import com.wecp.car_rental_management_system.repository.CarCategoryRepository;
import com.wecp.car_rental_management_system.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    // implement car service
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarCategoryRepository carCategoryRepository;
 
    public Car addCar(Car car){
        Long id = car.getCategory().getId();
        CarCategory carCat = new CarCategory();

        if(id != null )
            carCat = carCategoryRepository.findById(id).get();

        if(carCat != null){
            car.setCategory(carCat);
        }
        
        return carRepository.save(car);
    }

    public Car getCarById(Long carId){
        return carRepository.findById(carId).get();
    }
 
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
 
    public Car updateCar(Long id, Car car){
        car.setId(id);
        return carRepository.save(car);
    }
 
    public List<Car>getAvailableCars(){
        return carRepository.findByStatus("available");
    }
}
