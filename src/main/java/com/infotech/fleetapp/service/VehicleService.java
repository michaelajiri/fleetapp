package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.Vehicle;
import com.infotech.fleetapp.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Integer id){
        return vehicleRepository.findById(id);
    }

    public void addNewVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public void updateVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public void removeVehicle(Integer id){
        vehicleRepository.deleteById(id);
    }
}
