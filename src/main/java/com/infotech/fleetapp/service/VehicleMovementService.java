package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.VehicleMovement;
import com.infotech.fleetapp.repo.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService {

    private final VehicleMovementRepository vehicleMovementRepository;

    @Autowired
    public VehicleMovementService(VehicleMovementRepository vehicleMovementRepository) {
        this.vehicleMovementRepository = vehicleMovementRepository;
    }

    public List<VehicleMovement> getAllVehicleMovements(){
        return vehicleMovementRepository.findAll();
    }

    public Optional<VehicleMovement> getVehicleMovementById(Integer id){
        return vehicleMovementRepository.findById(id);
    }

    public void addNewVehicleMovement(VehicleMovement vehicleMovement){
        vehicleMovementRepository.save(vehicleMovement);
    }

    public void updateVehicleMovement(VehicleMovement vehicleMovement){
        vehicleMovementRepository.save(vehicleMovement);
    }

    public void removeVehicleMovement(Integer id){
        vehicleMovementRepository.deleteById(id);
    }
}
