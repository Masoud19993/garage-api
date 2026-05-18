package com.garage.garage_api.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage.garage_api.model.Car;
import com.garage.garage_api.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	private final CarService carService;
	
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping("/{immatriculation}")
	public ResponseEntity<Car> getCarByImmatriculation(@PathVariable String immatriculation) {
		Optional<Car> car = carService.getCarByImmatriculation(immatriculation);
		
		if (car.isPresent()) {
			return ResponseEntity.ok(car.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Car> addCar(@RequestBody Car car) {
		Car savedCar = carService.addCar(car);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
	}
	
	@PutMapping("/{immatriculation}")
	public ResponseEntity<Car> updateCarEtat(
			@PathVariable String immatriculation,
			@RequestBody Map<String, String> requestBody) {

        String nouvelEtat = requestBody.get("etat");
        Optional<Car> updatedCar = carService.updateCarEtat(immatriculation, nouvelEtat);

        if (updatedCar.isPresent()) {
            return ResponseEntity.ok(updatedCar.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{immatriculation}")
    public ResponseEntity<Void> deleteCar(@PathVariable String immatriculation) {
        boolean deleted = carService.deleteCarByImmatriculation(immatriculation);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}