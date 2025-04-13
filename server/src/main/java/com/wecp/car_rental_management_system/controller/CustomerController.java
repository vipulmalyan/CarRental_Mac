package com.wecp.car_rental_management_system.controller;


import com.wecp.car_rental_management_system.dto.BookingDto;
import com.wecp.car_rental_management_system.entity.Booking;
import com.wecp.car_rental_management_system.entity.Car;
import com.wecp.car_rental_management_system.service.BookingService;
import com.wecp.car_rental_management_system.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CarService carService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/api/customers/cars/available")
    public ResponseEntity<List<Car>> getAvailableCars() {
        // get all available cars.
        // note: return all the cars where car status is "available"
        List<Car> availabCars = carService.getAvailableCars();
        return ResponseEntity.ok(availabCars);
    }

    @PostMapping("/api/customers/booking")
    public ResponseEntity<Booking> bookCar(@RequestParam Long userId, @RequestParam Long carId,
                                           @RequestBody BookingDto bookingDto) {
        // book a car
        return new ResponseEntity<Booking>(bookingService.bookCar(userId, carId, bookingDto), HttpStatus.OK);
    }

    @GetMapping("/api/customers/bookings/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(bookingService.getBookingsByUserId(userId), HttpStatus.OK);
    }

}
