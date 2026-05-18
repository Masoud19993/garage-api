package com.garage.garage_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage.garage_api.model.Car;

public interface CarRepository extends JpaRepository<Car, String> {	
}