package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.EmployeeType;
import com.infotech.fleetapp.service.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

    private final EmployeeTypeService employeeTypeService;

    @Autowired
    public EmployeeTypeController(EmployeeTypeService employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    @RequestMapping(value = "/employeeTypes", method = RequestMethod.GET)
    public String employeeTypePage(Model model) {
        List<EmployeeType> listOfEmployeeTypes = employeeTypeService.getAllEmployeeTypes();
        model.addAttribute("listOfEmployeeTypes", listOfEmployeeTypes);
        return "employeeType";
    }

    @ResponseBody
    @RequestMapping(value = "/oneEmployeeType", method = RequestMethod.GET)
    public Optional<EmployeeType> getEmployeeTypeById(Integer id, Model model) {
        return employeeTypeService.getEmployeeTypeById(id);
    }

    @RequestMapping(value = "/addNewEmployeeType", method = RequestMethod.POST)
    public String addNewEmployeeType(EmployeeType employeeType) {
        employeeTypeService.addNewEmployeeType(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "/editEmployeeType", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateEmployeeType(EmployeeType employeeType) {
        employeeTypeService.updateEmployeeType(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "/deleteEmployeeType", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteEmployeeType(Integer id) {
        employeeTypeService.removeEmployeeType(id);
        return "redirect:/employeeTypes";
    }
}