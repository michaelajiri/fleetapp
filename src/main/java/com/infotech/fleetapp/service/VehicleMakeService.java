package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.VehicleMake;
import com.infotech.fleetapp.repo.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {

    private final VehicleMakeRepository vehicleMakeRepository;

    @Autowired
    public VehicleMakeService(VehicleMakeRepository vehicleMakeRepository) {
        this.vehicleMakeRepository = vehicleMakeRepository;
    }

    public List<VehicleMake> getAllVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    public Optional<VehicleMake> getVehicleMakeById(Integer id) {
        return vehicleMakeRepository.findById(id);
    }

    public void addNewVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    public void updateVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    public void removeVehicleMake(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}
