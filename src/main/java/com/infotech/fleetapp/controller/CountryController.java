package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.Country;
import com.infotech.fleetapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public String countryPage(Model model){
        List<Country> listOfCountries = countryService.getAllCountries();
        model.addAttribute("listOfCountries", listOfCountries);
        return "country";
    }

    @ResponseBody
    @RequestMapping(value = "/oneCountry", method = RequestMethod.GET)
    public Optional<Country> getCountryById(Integer id, Model model){
        return countryService.getCountryById(id);
    }

    @RequestMapping(value = "/addNewCountry", method = RequestMethod.POST)
    public String addNewCountry(Country country){
        countryService.addNewCountry(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/editCountry", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateCountry(Country country){
        countryService.updateCountry(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/deleteCountry", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String removeCountry(Integer id){
        countryService.removeCountry(id);
        return "redirect:/countries";
    }
}
