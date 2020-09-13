package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.VehicleModel;
import com.infotech.fleetapp.repo.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {

    private final VehicleModelRepository vehicleModelRepository;

    @Autowired
    public VehicleModelService(VehicleModelRepository vehicleModelRepository) {
        this.vehicleModelRepository = vehicleModelRepository;
    }

    public List<VehicleModel> getAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    public Optional<VehicleModel> getVehicleModelById(Integer id) {
        return vehicleModelRepository.findById(id);
    }

    public void addNewVehicleModel(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    public void updateVehicleModel(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    public void removeVehicleModel(Integer id) {
        vehicleModelRepository.deleteById(id);
    }
}
