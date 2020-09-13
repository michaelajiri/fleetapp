package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.VehicleStatus;
import com.infotech.fleetapp.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    private final VehicleStatusService vehicleStatusService;

    @Autowired
    public VehicleStatusController(VehicleStatusService vehicleStatusService) {
        this.vehicleStatusService = vehicleStatusService;
    }

    @RequestMapping(value = "/vehicleStatuses", method = RequestMethod.GET)
    public String vehicleStatusPage(Model model) {
        List<VehicleStatus> listOfVehicleStatuses = vehicleStatusService.getAllVehicleStatuses();
        model.addAttribute("listOfVehicleStatuses", listOfVehicleStatuses);
        return "vehicleStatus";
    }

    @ResponseBody
    @RequestMapping(value = "/oneVehicleStatus", method = RequestMethod.GET)
    public Optional<VehicleStatus> getVehicleStatusById(Integer id, Model model) {
        return vehicleStatusService.getVehicleStatusById(id);
    }

    @RequestMapping(value = "/addNewVehicleStatus", method = RequestMethod.POST)
    public String addNewVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusService.addNewVehicleStatus(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value = "/editVehicleStatus", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusService.updateVehicleStatus(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value = "/deleteVehicleStatus", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteVehicleStatus(Integer id){
        vehicleStatusService.removeVehicleStatus(id);
        return "redirect:/vehicleStatuses";
    }
}
