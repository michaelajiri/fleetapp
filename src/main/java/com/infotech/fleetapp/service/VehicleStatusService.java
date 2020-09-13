package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.VehicleStatus;
import com.infotech.fleetapp.repo.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    private final VehicleStatusRepository vehicleStatusRepository;

    @Autowired
    public VehicleStatusService(VehicleStatusRepository vehicleStatusRepository) {
        this.vehicleStatusRepository = vehicleStatusRepository;
    }

    public List<VehicleStatus> getAllVehicleStatuses() {
        return vehicleStatusRepository.findAll();
    }

    public Optional<VehicleStatus> getVehicleStatusById(Integer id) {
        return vehicleStatusRepository.findById(id);
    }

    public void addNewVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    public void updateVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    public void removeVehicleStatus(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }
}
