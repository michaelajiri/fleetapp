package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.VehicleHire;
import com.infotech.fleetapp.repo.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {

    private final VehicleHireRepository vehicleHireRepository;

    @Autowired
    public VehicleHireService(VehicleHireRepository vehicleHireRepository) {
        this.vehicleHireRepository = vehicleHireRepository;
    }

    public List<VehicleHire> getAllVehicleHires(){
        return vehicleHireRepository.findAll();
    }

    public Optional<VehicleHire> getVehicleHireById(Integer id){
        return vehicleHireRepository.findById(id);
    }

    public void addNewVehicleHire(VehicleHire vehicleHire){
        vehicleHireRepository.save(vehicleHire);
    }

    public void updateVehicleHire(VehicleHire vehicleHire){
        vehicleHireRepository.save(vehicleHire);
    }

    public void removeVehicleHire(Integer id){
        vehicleHireRepository.deleteById(id);
    }
}
