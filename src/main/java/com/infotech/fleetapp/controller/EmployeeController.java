package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.*;
import com.infotech.fleetapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeTypeService employeeTypeService;
    private final JobTitleService jobTitleService;
    private final CountryService countryService;

    @Autowired
    public EmployeeController(EmployeeService employeeService,
                              EmployeeTypeService employeeTypeService,
                              JobTitleService jobTitleService, CountryService countryService) {
        this.employeeService = employeeService;
        this.employeeTypeService = employeeTypeService;
        this.jobTitleService = jobTitleService;
        this.countryService = countryService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employeePage(Model model) {
        List<Employee> listOfEmployees = employeeService.getAllEmployees();
        model.addAttribute("listOfEmployees", listOfEmployees);
        List<EmployeeType> listOfEmployeeTypes = employeeTypeService.getAllEmployeeTypes();
        model.addAttribute("listOfEmployeeTypes", listOfEmployeeTypes);
        List<JobTitle> listOfJobTitles = jobTitleService.getAllJobTitles();
        model.addAttribute("listOfJobTitles", listOfJobTitles);
        List<Country> listOfCountries = countryService.getAllCountries();
        model.addAttribute("listOfCountries", listOfCountries);
        return "employee";
    }

    @ResponseBody
    @RequestMapping(value = "/oneEmployee", method = RequestMethod.GET)
    public Optional<Employee> getEmployeeById(Integer id, Model model) {
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
    public String addNewEmployee(Employee employee) {
        employeeService.addNewEmployee(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/editEmployee", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/deleteEmployee", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String removeEmployee(Integer id) {
        employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/assignUsername")
    public String assignUsername(Integer id){
        employeeService.assignUsername(id);
        return "redirect:/employees";
    }
}