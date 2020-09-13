package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.Client;
import com.infotech.fleetapp.model.Location;
import com.infotech.fleetapp.model.Vehicle;
import com.infotech.fleetapp.model.VehicleHire;
import com.infotech.fleetapp.service.ClientService;
import com.infotech.fleetapp.service.LocationService;
import com.infotech.fleetapp.service.VehicleHireService;
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
public class VehicleHireController {

    private final VehicleHireService vehicleHireService;
    private final VehicleService vehicleService;
    private final ClientService clientService;
    private final LocationService locationService;

    @Autowired
    public VehicleHireController(VehicleHireService vehicleHireService, VehicleService vehicleService,
                                 ClientService clientService, LocationService locationService) {
        this.vehicleHireService = vehicleHireService;
        this.vehicleService = vehicleService;
        this.clientService = clientService;
        this.locationService = locationService;
    }

    @RequestMapping(value = "/vehicleHire", method = RequestMethod.GET)
    public String vehicleHirePage(Model model) {
        List<VehicleHire> listOfVehicleHires = vehicleHireService.getAllVehicleHires();
        model.addAttribute("listOfVehicleHires", listOfVehicleHires);
        List<Vehicle> listOfVehicles = vehicleService.getAllVehicles();
        model.addAttribute("listOfVehicles", listOfVehicles);
        List<Client> listOfClients = clientService.getAllClients();
        model.addAttribute("listOfClients", listOfClients);
        List<Location> listOfLocations = locationService.getAllLocations();
        model.addAttribute("listOfLocations", listOfLocations);
        return "vehicleHire";
    }

    @ResponseBody
    @RequestMapping(value = "/oneVehicleHire", method = RequestMethod.GET)
    public Optional<VehicleHire> getVehicleHireById(Integer id, Model model) {
        return vehicleHireService.getVehicleHireById(id);
    }

    @RequestMapping(value = "/addNewVehicleHire", method = RequestMethod.POST)
    public String addNewVehicleHire(VehicleHire vehicleHire) {
        vehicleHireService.addNewVehicleHire(vehicleHire);
        return "redirect:/vehicleHire";
    }

    @RequestMapping(value = "/editVehicleHire", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateVehicleHire(VehicleHire VehicleHire) {
        vehicleHireService.updateVehicleHire(VehicleHire);
        return "redirect:/vehicleHire";
    }

    @RequestMapping(value = "/deleteVehicleHire", method = {RequestMethod.GET, RequestMethod.DELETE})
    public void deleteVehicleHire(Integer id){
        vehicleHireService.removeVehicleHire(id);
    }
}
