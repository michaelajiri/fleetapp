package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.*;
import com.infotech.fleetapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleController {

    private final VehicleService vehicleService;
    private final VehicleTypeService vehicleTypeService;
    private final VehicleMakeService vehicleMakeService;
    private final VehicleStatusService vehicleStatusService;
    private final EmployeeService employeeService;
    private final VehicleModelService vehicleModelService;
    private final LocationService locationService;

    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleTypeService vehicleTypeService,
                             VehicleMakeService vehicleMakeService, VehicleStatusService vehicleStatusService,
                             EmployeeService employeeService, VehicleModelService vehicleModelService,
                             LocationService locationService) {
        this.vehicleService = vehicleService;
        this.vehicleTypeService = vehicleTypeService;
        this.vehicleMakeService = vehicleMakeService;
        this.vehicleStatusService = vehicleStatusService;
        this.employeeService = employeeService;
        this.vehicleModelService = vehicleModelService;
        this.locationService = locationService;
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public String vehiclePage(Model model) {
        List<Vehicle> listOfVehicles = vehicleService.getAllVehicles();
        model.addAttribute("listOfVehicles", listOfVehicles);
        List<VehicleType> listOfVehicleTypes = vehicleTypeService.getAllVehicleTypes();
        model.addAttribute("listOfVehicleTypes", listOfVehicleTypes);
        List<VehicleMake> listOfVehicleMakes = vehicleMakeService.getAllVehicleMakes();
        model.addAttribute("listOfVehicleMakes", listOfVehicleMakes);
        List<VehicleStatus> listOfVehicleStatuses = vehicleStatusService.getAllVehicleStatuses();
        model.addAttribute("listOfVehicleStatuses", listOfVehicleStatuses);
        List<Employee> listOfEmployees = employeeService.getAllEmployees();
        model.addAttribute("listOfEmployees", listOfEmployees);
        List<VehicleModel> listOfVehicleModels = vehicleModelService.getAllVehicleModels();
        model.addAttribute("listOfVehicleModels", listOfVehicleModels);
        List<Location> listOfLocations = locationService.getAllLocations();
        model.addAttribute("listOfLocations", listOfLocations);
        return "vehicle";
    }

    @ResponseBody
    @RequestMapping(value = "/oneVehicle", method = RequestMethod.GET)
    public Optional<Vehicle> getVehicleById(Integer id, Model model) {
        return vehicleService.getVehicleById(id);
    }

    @RequestMapping(value = "/addNewVehicle", method = RequestMethod.POST)
    public String addNewVehicle(Vehicle vehicle) {
        vehicleService.addNewVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/editVehicle", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateVehicle(Vehicle vehicle) {
        vehicleService.updateVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/deleteVehicle", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteVehicle(Integer id){
        vehicleService.removeVehicle(id);
        return "redirect:/vehicles";
    }
}