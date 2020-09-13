package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.Location;
import com.infotech.fleetapp.model.Vehicle;
import com.infotech.fleetapp.model.VehicleMovement;
import com.infotech.fleetapp.service.LocationService;
import com.infotech.fleetapp.service.VehicleMovementService;
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
public class VehicleMovementController {

    private final VehicleMovementService vehicleMovementService;
    private final VehicleService vehicleService;
    private final LocationService locationService;

    @Autowired
    public VehicleMovementController(VehicleMovementService vehicleMovementService,
                                     VehicleService vehicleService, LocationService locationService) {
        this.vehicleMovementService = vehicleMovementService;
        this.vehicleService = vehicleService;
        this.locationService = locationService;
    }

    @RequestMapping(value = "/vehicleMovements", method = RequestMethod.GET)
    public String vehicleMovementPage(Model model) {
        List<VehicleMovement> listOfVehicleMovements = vehicleMovementService.getAllVehicleMovements();
        model.addAttribute("listOfVehicleMovements", listOfVehicleMovements);
        List<Vehicle> listOfVehicles = vehicleService.getAllVehicles();
        model.addAttribute("listOfVehicles", listOfVehicles);
        List<Location> listOfLocations = locationService.getAllLocations();
        model.addAttribute("listOfLocations", listOfLocations);
        return "vehicleMovement";
    }

    @ResponseBody
    @RequestMapping(value = "/oneVehicleMovement", method = RequestMethod.GET)
    public Optional<VehicleMovement> getVehicleMovementById(Integer id, Model model) {
        return vehicleMovementService.getVehicleMovementById(id);
    }

    @RequestMapping(value = "/addNewVehicleMovement", method = RequestMethod.POST)
    public String addNewVehicleMovement(VehicleMovement vehicleMovement) {
        vehicleMovementService.addNewVehicleMovement(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "/editVehicleMovement", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateVehicleMovement(VehicleMovement vehicleMovement) {
        vehicleMovementService.updateVehicleMovement(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "/deleteVehicleMovement", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteVehicleMovement(Integer id){
        vehicleMovementService.removeVehicleMovement(id);
        return "redirect:/vehicleMovements";
    }
}
