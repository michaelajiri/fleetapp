package com.infotech.fleetapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(){
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(){
        return "register";
    }
}
