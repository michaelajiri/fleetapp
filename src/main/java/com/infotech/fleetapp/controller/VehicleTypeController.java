package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.VehicleType;
import com.infotech.fleetapp.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {

    private final VehicleTypeService vehicleTypeService;

    @Autowired
    public VehicleTypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @RequestMapping(value = "/vehicleTypes", method = RequestMethod.GET)
    public String vehicleTypePage(Model model) {
        List<VehicleType> listOfVehicleTypes = vehicleTypeService.getAllVehicleTypes();
        model.addAttribute("listOfVehicleTypes", listOfVehicleTypes);
        return "vehicleType";
    }

    @ResponseBody
    @RequestMapping(value = "/oneVehicleType", method = RequestMethod.GET)
    public Optional<VehicleType> getVehicleTypeById(Integer id, Model model) {
        return vehicleTypeService.getVehicleTypeById(id);
    }

    @RequestMapping(value = "/addNewVehicleType", method = RequestMethod.POST)
    public String addNewVehicleType(VehicleType vehicleType) {
        vehicleTypeService.addNewVehicleType(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value = "/editVehicleType", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateVehicleType(VehicleType vehicleType) {
        vehicleTypeService.updateVehicleType(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value = "/deleteVehicleType", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteVehicleType(Integer id){
        vehicleTypeService.removeVehicleType(id);
        return "redirect:/vehicleMakes";
    }
}
