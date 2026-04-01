package com.garage.garage_api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garage.garage_api.model.Car;
import com.garage.garage_api.repository.CarRepository;

@Service
public class CarService {
	
	private final CarRepository carRepository;
	
	public CarService(CarRepository carRipository) {
		this.carRepository = carRipository;
	}
	
	
	public Optional<Car> getCarByImmatriculation(String immatriculation) {
		return carRepository.findById(immatriculation);
	}
	
	public Car addCar(Car car) {
        if (carRepository.existsById(car.getImmatriculation())) {
            throw new RuntimeException("Une voiture avec cette immatriculation existe déjà.");
        }
        return carRepository.save(car);
    }
	
	public Optional<Car> updateCarEtat(String immatriculation, String nouvelEtat) {
		Optional<Car> optionalCar = carRepository.findById(immatriculation);
		
		if (optionalCar.isPresent()) {
			Car car = optionalCar.get();
			car.setEtat(nouvelEtat);
			Car updatedCar = carRepository.save(car);
			return Optional.of(updatedCar);
		}
		
		return Optional.empty();
	}
	
	public boolean deleteCarByImmatriculation(String immtriculation) {
		if (carRepository.existsById(immtriculation)) {
			carRepository.deleteById(immtriculation);
			return true;
		}
		return false;
	}
	
	
}