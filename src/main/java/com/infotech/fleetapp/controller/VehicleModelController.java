package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.VehicleModel;
import com.infotech.fleetapp.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    private final VehicleModelService vehicleModelService;

    @Autowired
    public VehicleModelController(VehicleModelService vehicleModelService) {
        this.vehicleModelService = vehicleModelService;
    }

    @RequestMapping(value = "/vehicleModels", method = RequestMethod.GET)
    public String vehicleModelPage(Model model) {
        List<VehicleModel> listOfVehicleModels = vehicleModelService.getAllVehicleModels();
        model.addAttribute("listOfVehicleModels", listOfVehicleModels);
        return "vehicleModel";
    }

    @ResponseBody
    @RequestMapping(value = "/oneVehicleModel", method = RequestMethod.GET)
    public Optional<VehicleModel> getVehicleModelById(Integer id, Model model) {
        return vehicleModelService.getVehicleModelById(id);
    }

    @RequestMapping(value = "/addNewVehicleModel", method = RequestMethod.POST)
    public String addNewVehicleModel(VehicleModel vehicleModel) {
        vehicleModelService.addNewVehicleModel(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value = "/editVehicleModel", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateVehicleModel(VehicleModel vehicleModel) {
        vehicleModelService.updateVehicleModel(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value = "/deleteVehicleModel", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteVehicleModel(Integer id){
        vehicleModelService.removeVehicleModel(id);
        return "redirect:/vehicleModels";
    }
}
