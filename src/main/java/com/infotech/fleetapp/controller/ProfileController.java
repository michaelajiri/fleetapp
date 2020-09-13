package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    private final EmployeeService employeeService;

    @Autowired
    public ProfileController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/profile")
    public String profile(Model model, Principal principal){
        String username = principal.getName();
        model.addAttribute("employee", employeeService.findByUsername(username));
        return "profile";
    }
}
