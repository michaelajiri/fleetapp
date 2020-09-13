package com.infotech.fleetapp.repo;

import com.infotech.fleetapp.model.VehicleMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMaintenanceRepository extends JpaRepository<VehicleMaintenance, Integer>{
	
	

}
