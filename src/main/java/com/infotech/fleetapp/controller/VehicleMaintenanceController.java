package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.Supplier;
import com.infotech.fleetapp.model.Vehicle;
import com.infotech.fleetapp.model.VehicleMaintenance;
import com.infotech.fleetapp.service.SupplierService;
import com.infotech.fleetapp.service.VehicleMaintenanceService;
import com.infotech.fleetapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMaintenanceController {

    private final VehicleMaintenanceService vehicleMaintenanceService;
    private final VehicleService vehicleService;
    private final SupplierService supplierService;

    @Autowired
    public VehicleMaintenanceController(VehicleMaintenanceService vehicleMaintenanceService,
                                        VehicleService vehicleService, SupplierService supplierService) {
        this.vehicleMaintenanceService = vehicleMaintenanceService;
        this.vehicleService = vehicleService;
        this.supplierService = supplierService;
    }

    @RequestMapping(value = "/vehicleMaintenance", method = RequestMethod.GET)
    public String vehicleMaintenancePage(Model model) {
        List<VehicleMaintenance> listOfVehicleMaintenance = vehicleMaintenanceService.getAllVehicleMaintenance();
        model.addAttribute("listOfVehicleMaintenance", listOfVehicleMaintenance);
        List<Vehicle> listOfVehicles = vehicleService.getAllVehicles();
        model.addAttribute("listOfVehicles", listOfVehicles);
        List<Supplier> listOfSuppliers = supplierService.getAllSuppliers();
        model.addAttribute("listOfSuppliers", listOfSuppliers);
        return "vehicleMaintenance";
    }

    @ResponseBody
    @RequestMapping(value = "/oneVehicleMaintenance", method = RequestMethod.GET)
    public Optional<VehicleMaintenance> getVehicleMaintenanceById(Integer id, Model model) {
        return vehicleMaintenanceService.getVehicleMaintenanceById(id);
    }

    @RequestMapping(value = "/addNewVehicleMaintenance", method = RequestMethod.POST)
    public String addNewVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.addNewVehicleMaintenance(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }

    @RequestMapping(value = "/editVehicleMaintenance", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.updateVehicleMaintenance(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }

    @RequestMapping(value = "/deleteVehicleMaintenance", method = {RequestMethod.GET, RequestMethod.DELETE})
    public void deleteVehicleMaintenance(Integer id){
        vehicleMaintenanceService.removeVehicleMaintenance(id);
    }
}
