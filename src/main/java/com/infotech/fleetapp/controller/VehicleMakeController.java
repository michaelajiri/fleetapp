package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.VehicleMake;
import com.infotech.fleetapp.service.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {

    private final VehicleMakeService vehicleMakeService;

    @Autowired
    public VehicleMakeController(VehicleMakeService vehicleMakeService) {
        this.vehicleMakeService = vehicleMakeService;
    }

    @RequestMapping(value = "/vehicleMakes", method = RequestMethod.GET)
    public String vehicleMakePage(Model model) {
        List<VehicleMake> listOfVehicleMakes = vehicleMakeService.getAllVehicleMakes();
        model.addAttribute("listOfVehicleMakes", listOfVehicleMakes);
        return "vehicleMake";
    }

    @ResponseBody
    @RequestMapping(value = "/oneVehicleMake", method = RequestMethod.GET)
    public Optional<VehicleMake> getVehicleMakeById(Integer id, Model model) {
        return vehicleMakeService.getVehicleMakeById(id);
    }

    @RequestMapping(value = "/addNewVehicleMake", method = RequestMethod.POST)
    public String addNewVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeService.addNewVehicleMake(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping(value = "/editVehicleMake", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeService.updateVehicleMake(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping(value = "/deleteVehicleMake", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteVehicleMake(Integer id){
        vehicleMakeService.removeVehicleMake(id);
        return "redirect:/vehicleMakes";
    }
}
