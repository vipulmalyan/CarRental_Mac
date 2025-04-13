package com.wecp.car_rental_management_system.repository;


import com.wecp.car_rental_management_system.entity.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCategoryRepository extends JpaRepository<CarCategory,Long> {
    // implement jpa repository here
}

