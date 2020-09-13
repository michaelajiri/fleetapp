package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.VehicleMaintenance;
import com.infotech.fleetapp.repo.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceService {

    private final VehicleMaintenanceRepository vehicleMaintenanceRepository;

    @Autowired
    public VehicleMaintenanceService(VehicleMaintenanceRepository vehicleMaintenanceRepository) {
        this.vehicleMaintenanceRepository = vehicleMaintenanceRepository;
    }

    public List<VehicleMaintenance> getAllVehicleMaintenance(){
        return vehicleMaintenanceRepository.findAll();
    }

    public Optional<VehicleMaintenance> getVehicleMaintenanceById(Integer id){
        return vehicleMaintenanceRepository.findById(id);
    }

    public void addNewVehicleMaintenance(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    public void updateVehicleMaintenance(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    public void removeVehicleMaintenance(Integer id){
        vehicleMaintenanceRepository.deleteById(id);
    }
}
