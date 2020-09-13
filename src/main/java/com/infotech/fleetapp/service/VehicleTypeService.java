package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.VehicleType;
import com.infotech.fleetapp.repo.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {

    private final VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    public Optional<VehicleType> getVehicleTypeById(Integer id) {
        return vehicleTypeRepository.findById(id);
    }

    public void addNewVehicleType(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    public void updateVehicleType(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    public void removeVehicleType(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }
}
